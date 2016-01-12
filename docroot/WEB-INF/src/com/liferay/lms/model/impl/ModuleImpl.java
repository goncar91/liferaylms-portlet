/**
 * Copyright (c)2013 Telefonica Learning Services. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.lms.model.impl;

import com.liferay.lms.model.Course;
import com.liferay.lms.model.Module;
import com.liferay.lms.service.CourseLocalServiceUtil;
import com.liferay.lms.service.ModuleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model implementation for the Module service. Represents a row in the &quot;Lms_Module&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.lms.model.Module} interface.
 * </p>
 *
 * @author TLS
 */
public class ModuleImpl extends ModuleBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a module model instance should use the {@link com.liferay.lms.model.Module} interface instead.
	 */
	public ModuleImpl() {
	}
	public Module getParentModule() throws SystemException, PortalException
	{
		Course course=CourseLocalServiceUtil.getCourseByGroupCreatedId(this.getGroupId());
		if(course!=null)
		{
			Course parentCourse=course.getParentCourse();
			if(parentCourse!=null)
			{
				return ModuleLocalServiceUtil.getModuleByUuidAndGroupId(this.getUuid(), parentCourse.getGroupCreatedId());
			}
		}
		return null;
	}
}