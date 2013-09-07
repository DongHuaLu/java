package com.dolph.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Service;

import com.dolph.Dao.ResourceDao;
import com.dolph.annotations.Oper;
import com.dolph.annotations.Res;
import com.dolph.model.ActionMethodOper;
import com.dolph.model.ActionResource;
import com.dolph.service.ResourceService;
import com.dolph.vo.PageVo;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
	Logger logger = Logger.getLogger(ResourceServiceImpl.class);
	private ResourceDao resourceDao;

	@Override
	public void rebuildActionResource() {
		try {
			String path = "com/dolph/web/**/*Action.class";
			ResourcePatternResolver reslver = new PathMatchingResourcePatternResolver();
			// 得到所有Action资源集合
			Resource[] res = reslver.getResources(path);
			if (res != null) {
				MetadataReaderFactory metaFactroy = new CachingMetadataReaderFactory();
				for (Resource resource : res) {
					MetadataReader metaReader = metaFactroy
							.getMetadataReader(resource);

					saveActionResource(metaReader, metaFactroy, reslver);
				}
			List<ActionResource> resources=resourceDao.findAll();
			for(ActionResource ar:resources){
				String parentSn=ar.getParentSn();
				if(parentSn!=null&&!"".equals(parentSn)){
					ActionResource parent=resourceDao.findActionResourceBySn(parentSn);
					if(parent!=null)
					ar.setParent(parent);
				}
			}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void saveActionResource(MetadataReader metaReader,
			MetadataReaderFactory metaFactroy, ResourcePatternResolver reslver)
			throws IOException {
		ClassMetadata classMetadata = metaReader.getClassMetadata();
		AnnotationMetadata annotationMetadata = metaReader
				.getAnnotationMetadata();
		if (annotationMetadata.hasAnnotation(Res.class.getName())) {
			logger.debug("扫描到[" + classMetadata.getClassName() + "]有@Res注解!");
			Map resAttrs = annotationMetadata.getAnnotationAttributes(Res.class
					.getName());
			// 得到Res注解属性
			String sn = (String) resAttrs.get("sn");
			String name = (String) resAttrs.get("name");
			int orderNumber = (Integer) resAttrs.get("orderNumber");
			String parentSn = (String) resAttrs.get("parentSn");
			String className = classMetadata.getClassName();
			/********************* 根据信息创建ActionResource ********************************/
			ActionResource ar = resourceDao.findActionResourceBySn(sn);
			if (ar == null) {
				ar = new ActionResource();
			}
			ar.addClassName(className);
			ar.setName(name);
			ar.setParentSn(parentSn);			
			ar.setOrderNumber(orderNumber);
			ar.setSn(sn);
					
			logger.debug("扫描到资源[" + sn + "(" + name + ")]");

			searchOperAnnotations(ar, metaReader, metaFactroy, reslver);
			resourceDao.save(ar);
		}
	}

	private void searchOperAnnotations(ActionResource ar,
			MetadataReader metaReader, MetadataReaderFactory metaFactroy,
			ResourcePatternResolver reslver) throws IOException {
		AnnotationMetadata annotationMetadata = metaReader
				.getAnnotationMetadata();
		Set<MethodMetadata> mmds = annotationMetadata
				.getAnnotatedMethods(Oper.class.getName());
		if (mmds != null) {
			for (MethodMetadata mmd : mmds) {
				Map operAttrs = mmd.getAnnotationAttributes(Oper.class
						.getName());
				String methodName = mmd.getMethodName();
				// 得到@Oper属性,并封装添加到ar中
				String operName = (String) operAttrs.get("name");
				if (operName == null || "".equals(operName)) {
					operName = getDefaultName(methodName);
				}
				String operSn = (String) operAttrs.get("sn");
				if (operSn == null || "".equals(operSn)) {
					operSn = getDefaultSn(methodName);
				}
				int operIndex = (Integer) operAttrs.get("operIndex");
				if (operIndex == -1) {
					operIndex = getDefaultIndex(methodName);
				}
				ar.addActionMethodOper(methodName, operName, operSn, operIndex);

				}
			// 如果有父类,并且不是java.lang.Object,则继续搜索是否含有@Oper注解的方法
			String superClassName = metaReader.getClassMetadata()
					.getSuperClassName();
			if (metaReader.getClassMetadata().hasSuperClass()
					&& !superClassName.equals(Object.class.getName())) {
				String superClassPath = superClassName.replace(".", "/")
						+ ".class";
				Resource superClassResource = reslver
						.getResource(superClassPath);
				searchOperAnnotations(ar,
						metaFactroy.getMetadataReader(superClassResource),
						metaFactroy, reslver);
			}
		}
	}

	private int getDefaultIndex(String methodName) {
		if (methodName.startsWith("add")) {
			return 0;
		} else if (methodName.startsWith("update")) {
			return 1;
		} else if (methodName.startsWith("del")) {
			return 2;
		}
		return 3;
	}

	private String getDefaultSn(String methodName) {
		if (methodName.startsWith("add")) {
			return "CREATE";
		} else if (methodName.startsWith("update")) {
			return "UPDATE";
		} else if (methodName.startsWith("del")) {
			return "DELETE";
		}
		return "READ";
	}

	private String getDefaultName(String methodName) {
		if (methodName.startsWith("add")) {
			return "添加";
		} else if (methodName.startsWith("update")) {
			return "更新";
		} else if (methodName.startsWith("del")) {
			return "删除";
		}
		return "查询";
	}

	@javax.annotation.Resource
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	@Override
	public void addActionResource(ActionResource actionResource) {
		resourceDao.save(actionResource);
	}

	@Override
	public List<ActionResource> findRootActionResources() {
		return resourceDao.findRootActionResources();
	}

	@Override
	public ActionResource findActionResourceById(int id) {
		return resourceDao.findById(ActionResource.class, id);
	}

	@Override
	public void update(ActionResource actionResource) {
		resourceDao.update(actionResource);

	}

	@Override
	public void delete(int actionResourceId) {
		resourceDao.dalete(findActionResourceById(actionResourceId));
	}

	@Override
	public void addActionResourceOper(int id, ActionMethodOper amoper) {
		ActionResource ar = findActionResourceById(id);
		ar.addActionMethodOper(amoper.getMethodName(), amoper.getOperName(),
				amoper.getOperSn(), amoper.getOperIndex());
	}

	@Override
	public void deleteActionResourceOper(int id, String operSn) {
		ActionResource ar = findActionResourceById(id);
		ar.getOpers().remove(operSn);

	}

	@Override
	public List<ActionResource> findAllActionResources() {
		return resourceDao.findAll();
	}
	
}
