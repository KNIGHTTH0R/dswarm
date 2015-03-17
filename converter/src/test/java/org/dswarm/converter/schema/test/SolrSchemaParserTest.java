/**
 * Copyright (C) 2013 – 2015 SLUB Dresden & Avantgarde Labs GmbH (<code@dswarm.org>)
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
package org.dswarm.converter.schema.test;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import org.dswarm.converter.GuicedTest;
import org.dswarm.converter.schema.SolrSchemaParser;
import org.dswarm.persistence.DMPPersistenceException;
import org.dswarm.persistence.model.schema.Attribute;
import org.dswarm.persistence.model.schema.AttributePath;
import org.dswarm.persistence.model.schema.Schema;
import org.dswarm.persistence.model.schema.SchemaAttributePathInstance;
import org.dswarm.persistence.model.schema.utils.SchemaUtils;
import org.dswarm.persistence.util.DMPPersistenceUtil;

/**
 * @author tgaengler
 */
public class SolrSchemaParserTest extends GuicedTest {

	/**
	 * @throws DMPPersistenceException
	 */
	@Test
	public void testFincSolrSchemaCreation() throws DMPPersistenceException, IOException {

		final Schema schema = parseFincSolrSchema();

		final Collection<SchemaAttributePathInstance> sapis = schema.getAttributePaths();

		Assert.assertNotNull(sapis);
		Assert.assertFalse(sapis.isEmpty());

		final StringBuilder sb = new StringBuilder();

		for(final SchemaAttributePathInstance sapi : sapis) {

			final AttributePath attributePath = sapi.getAttributePath();

			Assert.assertNotNull(attributePath);

			final List<Attribute> attributes = attributePath.getAttributePath();

			Assert.assertNotNull(attributes);
			Assert.assertFalse(attributes.isEmpty());

			final Attribute attribute = attributes.get(0);

			final String attributeURI = attribute.getUri();

			Assert.assertNotNull(attributeURI);
			Assert.assertFalse(attributeURI.trim().isEmpty());

			sb.append(attributeURI).append("\n");
		}

		final String expectedAttributePaths = DMPPersistenceUtil.getResourceAsString("finc-solr-schema_-_attribute_paths.txt");

		Assert.assertNotNull(expectedAttributePaths);

		final String actualAttributePaths = sb.toString();

		Assert.assertEquals(expectedAttributePaths, actualAttributePaths);
	}

	public static Schema parseFincSolrSchema() throws DMPPersistenceException {

		final String name = "finc Solr schema";

		return parseSchema("finc-solr-schema.xml", SchemaUtils.FINC_SOLR_SCHEMA_UUID, name);
	}

	private static Schema parseSchema(final String solrSchemaFileName, final String schemaUUID, final String schemaName)
			throws DMPPersistenceException {

		final SolrSchemaParser solrSchemaParser = GuicedTest.injector.getInstance(SolrSchemaParser.class);
		final Optional<Schema> optionalSchema = solrSchemaParser.parse(solrSchemaFileName, schemaUUID, schemaName);

		Assert.assertTrue(optionalSchema.isPresent());

		return optionalSchema.get();
	}
}