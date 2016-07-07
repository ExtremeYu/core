package com.dotcms.contenttype.business;

import java.util.List;

import com.dotcms.contenttype.model.type.BaseContentTypes;
import com.dotcms.contenttype.model.type.ContentType;
import com.dotmarketing.exception.DotDataException;

public interface ContentTypeFactory {
	
	
	default ContentTypeFactory instance(){
		return new ContentTypeFactoryImpl();
	}
	
	
	ContentType find(String id) throws DotDataException;
	
	ContentType findByVar(String id) throws DotDataException;

	List<ContentType> findAll() throws DotDataException;

	List<ContentType> findAll(String orderBy) throws DotDataException;

	List<ContentType> findByBaseType(BaseContentTypes type) throws DotDataException;

	List<ContentType> findByBaseType(int type) throws DotDataException;


	ContentType save(ContentType type) throws DotDataException;


	List<ContentType> search(String search, String orderBy) throws DotDataException;


	List<ContentType> search(String search, String orderBy, int limit) throws DotDataException;
	
	List<ContentType> search(String search, String orderBy, int offset,int limit) throws DotDataException;


	List<ContentType> search(String search) throws DotDataException;


	int searchCount(String search) throws DotDataException;


	int searchCount(String search, int baseType) throws DotDataException;


	List<ContentType> search(String search, int baseType, String orderBy, int offset, int limit) throws DotDataException;
	
	List<ContentType> search(String search, BaseContentTypes type, String orderBy, int offset, int limit) throws DotDataException;


	int searchCount(String search, BaseContentTypes baseType) throws DotDataException;
	
	
	
}