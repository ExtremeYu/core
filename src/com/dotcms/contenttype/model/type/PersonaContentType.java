package com.dotcms.contenttype.model.type;

import org.immutables.value.Value;

@Value.Immutable
public abstract class PersonaContentType extends ContentType{



	private static final long serialVersionUID = 1L;

	@Override
	public  BaseContentTypes baseType() {
		return  BaseContentTypes.PERSONA;
	}

	@Override
	public boolean versionable(){
		return true;
	}
	
	
	
	public abstract static class Builder implements ContentTypeBuilder {}
	
	
	
	
	

}