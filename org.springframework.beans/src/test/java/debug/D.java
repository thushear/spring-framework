/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package debug;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import org.springframework.beans.factory.ConcurrentBeanFactoryTests;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * 说明: User: kongming Date: 2015/8/6 Time: 20:05
 */
public class D {

	/**
	 * get FileSystemResource
	 * @param clazz
	 * @return
	 */
	public static Resource getTestFileSystemResource(Class clazz){
		org.springframework.util.Assert.notNull(clazz,"clazz must not be null");
		System.out.println(clazz.getSimpleName() + "--" + clazz.getCanonicalName() + "---" + clazz.getPackage() + "------" );

		return  new FileSystemResource(new File("src/test/java/" + clazz.getCanonicalName().substring(0,clazz.getCanonicalName().lastIndexOf(".")).replace(".","/") + "/" + String.format("%s-%s", clazz.getSimpleName() , "context.xml")));
	}


	/**
	 *
	 * @param clazz
	 * @return
	 */
	public static Resource getTestResource(Class clazz){
		Assert.assertNotNull(clazz);
		return new ClassPathResource(String.format("%s-%s", clazz.getSimpleName() , "context.xml"),clazz);
	}


	@Test
	public void  testClassPathResource(){
		Resource resource = new ClassPathResource(String.format("%s-%s", ConcurrentBeanFactoryTests.class.getSimpleName() , "context.xml"),ConcurrentBeanFactoryTests.class);
		System.out.println(resource);
	}

	@Test
	public void testGetTestFileSystemResource(){
		 FileSystemResource fileSystemResource =
				 (FileSystemResource) D.getTestFileSystemResource(ConcurrentBeanFactoryTests.class);
		System.out.println(fileSystemResource);

	}


}
