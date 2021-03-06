/**
 * Copyright (C) 2013 – 2017 SLUB Dresden & Avantgarde Labs GmbH (<code@dswarm.org>)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dswarm.controller.resources.job.test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.dswarm.common.MediaTypeUtil;
import org.dswarm.persistence.model.resource.utils.ConfigurationStatics;

public class TasksResourceTestDD1319JSCLDJ extends AbtractExportOnTheFlyTasksResourceTest {

	private static final Logger LOG = LoggerFactory.getLogger(TasksResourceTestDD1319JSCLDJ.class);

	public TasksResourceTestDD1319JSCLDJ() {

		super("dd-1319/task.of.project.7ed16f4c-331c-6213-15f5-b1992d0fc422.json",
				"dd-1387/input.xml",
				"Publisher",
				ConfigurationStatics.XML_STORAGE_TYPE,
				"dd-1319/jsc.ldj.result.ldj",
				"01",
				true,
				MediaTypeUtil.JSC_LDJ_TYPE);
	}

	@Override
	protected void doComparison(final String expectedResult,
	                            final InputStream actualResult) {

		try {

			final String actualResultString = IOUtils.toString(actualResult, StandardCharsets.UTF_8);

			Assert.assertEquals(expectedResult, actualResultString);
		} catch (final IOException e) {

			LOG.error("some thing went wrong", e);

			Assert.assertTrue(false);
		}

	}
}
