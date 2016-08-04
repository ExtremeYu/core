package com.dotcms.contenttype.model.type;

import java.util.List;

import org.immutables.value.Value;

import com.dotcms.contenttype.model.field.DataTypes;
import com.dotcms.contenttype.model.field.Field;
import com.dotcms.contenttype.model.field.ImmutableConstantField;
import com.dotcms.contenttype.model.field.ImmutableTextField;
import com.dotcms.repackage.com.google.common.collect.ImmutableList;
import com.google.common.base.Preconditions;

@Value.Immutable
public abstract class WidgetContentType extends ContentType {
	
	private final String WIDGET_CODE_FIELD_NAME = "Widget Code";
	private final String WIDGET_CODE_FIELD_VAR = "widgetCode";
	private final String WIDGET_USAGE_FIELD_NAME = "Widget Usage";
	private final String WIDGET_USAGE_FIELD_VAR = "widgetUsage";
	private final String WIDGET_TITLE_FIELD_NAME = "Widget Title";
	private final String WIDGET_TITLE_FIELD_VAR = "widgetTitle";
	private final String WIDGET_PRE_EXECUTE_FIELD_NAME = "Widget Pre-Execute";
	private final String WIDGET_PRE_EXECUTE_FIELD_VAR = "widgetPreexecute";
	public abstract static class Builder implements ContentTypeBuilder {}
	private static final long serialVersionUID = 1L;

	@Override
	public BaseContentType baseType() {
		return BaseContentType.WIDGET;
	}
	@Value.Default
	public boolean multilingualable(){
		return false;
	}
	
	@Value.Check
	protected void check() {
		Preconditions.checkArgument(pagedetail()==null,"Detail Page cannot be set for widgets");
		Preconditions.checkArgument(urlMapPattern()==null,"urlmap cannot be set for widgets");
		Preconditions.checkArgument(expireDateVar()==null,"expireDate cannot be set for widgets");
		Preconditions.checkArgument(publishDateVar()==null,"expireDate cannot be set for widgets");
		Preconditions.checkArgument(multilingualable()!=true,"multilingual cannot be set for widgets");
	}
	
	
	public  List<Field> requiredFields(){
		Field titleField = ImmutableTextField.builder()
				.name(WIDGET_TITLE_FIELD_NAME)
				.dataType(DataTypes.TEXT)
				.variable(WIDGET_TITLE_FIELD_VAR)
				.required(true)
				.listed(true)
				.indexed(true)
				.sortOrder(1)
				.fixed(true)
				.searchable(true)
				.build();
		
		Field preExecute = ImmutableConstantField.builder()
				.name(WIDGET_PRE_EXECUTE_FIELD_NAME)
				.dataType(DataTypes.CONSTANT)
				.variable(WIDGET_PRE_EXECUTE_FIELD_VAR)
				.sortOrder(4)
				.fixed(true)
				.readOnly(true)
				.searchable(true)
				.build();
		
		
		Field codeField = ImmutableConstantField.builder()
				.name(WIDGET_CODE_FIELD_NAME)
				.dataType(DataTypes.CONSTANT)
				.variable(WIDGET_CODE_FIELD_VAR)
				.sortOrder(3)
				.fixed(true)
				.readOnly(true)
				.searchable(true)
				.build();
		
		Field usageField = ImmutableConstantField.builder()
				.name(WIDGET_USAGE_FIELD_NAME)

				.dataType(DataTypes.CONSTANT)
				.variable(WIDGET_USAGE_FIELD_VAR)
				.sortOrder(2)
				.fixed(true)
				.readOnly(true)
				.searchable(true)
				.build();
		

		
		return ImmutableList.of(titleField,usageField,codeField,preExecute);
		
		
		
	}
}