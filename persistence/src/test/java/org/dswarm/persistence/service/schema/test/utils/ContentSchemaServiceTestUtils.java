package org.dswarm.persistence.service.schema.test.utils;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import org.junit.Assert;

import org.dswarm.persistence.model.schema.AttributePath;
import org.dswarm.persistence.model.schema.ContentSchema;
import org.dswarm.persistence.model.schema.proxy.ProxyContentSchema;
import org.dswarm.persistence.service.schema.ContentSchemaService;
import org.dswarm.persistence.service.test.utils.BasicDMPJPAServiceTestUtils;

public class ContentSchemaServiceTestUtils extends BasicDMPJPAServiceTestUtils<ContentSchemaService, ProxyContentSchema, ContentSchema> {

	private final AttributePathServiceTestUtils	attributePathsResourceTestUtils;

	public ContentSchemaServiceTestUtils() {

		super(ContentSchema.class, ContentSchemaService.class);

		attributePathsResourceTestUtils = new AttributePathServiceTestUtils();
	}

	@Override
	public void compareObjects(final ContentSchema expectedObject, final ContentSchema actualObject) {

		super.compareObjects(expectedObject, actualObject);

		compareContentSchemas(expectedObject, actualObject);
	}

	public ContentSchema createContentSchema(final String name, final LinkedList<AttributePath> keyAttributePaths,
			final AttributePath valueAttributePath) throws Exception {

		final ContentSchema contentSchema = new ContentSchema();

		contentSchema.setName(name);
		contentSchema.setKeyAttributePaths(keyAttributePaths);
		contentSchema.setValueAttributePath(valueAttributePath);

		return createContentSchemaInternal(contentSchema);
	}

	public ContentSchema createContentSchema(final ContentSchema contentSchema) throws Exception {

		return createContentSchemaInternal(contentSchema);
	}

	private ContentSchema createContentSchemaInternal(final ContentSchema contentSchema) throws Exception {

		// update content schema

		final ContentSchema updatedContentSchema = createObject(contentSchema, contentSchema);

		Assert.assertNotNull("updated content schema shouldn't be null", updatedContentSchema);
		Assert.assertNotNull("updated content schema id shouldn't be null", updatedContentSchema.getId());

		return updatedContentSchema;
	}

	private void compareContentSchemas(final ContentSchema expectedContentSchema, final ContentSchema actualContentSchema) {

		if (expectedContentSchema.getKeyAttributePaths() != null && !expectedContentSchema.getKeyAttributePaths().isEmpty()) {

			final Set<AttributePath> actualUtilisedKeyAttributePaths = actualContentSchema.getUtilisedKeyAttributePaths();

			Assert.assertNotNull("key attribute paths of actual content schema '" + actualContentSchema.getId() + "' shouldn't be null",
					actualUtilisedKeyAttributePaths);
			Assert.assertFalse("attribute paths of actual content schema '" + actualContentSchema.getId() + "' shouldn't be empty",
					actualUtilisedKeyAttributePaths.isEmpty());

			final Map<Long, AttributePath> actualKeyAttributePathsMap = Maps.newHashMap();

			for (final AttributePath actualKeyAttributePath : actualUtilisedKeyAttributePaths) {

				actualKeyAttributePathsMap.put(actualKeyAttributePath.getId(), actualKeyAttributePath);
			}

			attributePathsResourceTestUtils.compareObjects(expectedContentSchema.getUtilisedKeyAttributePaths(), actualKeyAttributePathsMap);
		}

		if (expectedContentSchema.getValueAttributePath() != null) {

			attributePathsResourceTestUtils
					.compareObjects(expectedContentSchema.getValueAttributePath(), actualContentSchema.getValueAttributePath());
		}
	}

	/**
	 * {@inheritDoc}<br/>
	 * Updates the name, key attribute paths and value attribute path of the content schema.
	 */
	@Override
	protected ContentSchema prepareObjectForUpdate(final ContentSchema objectWithUpdates, final ContentSchema object) {

		super.prepareObjectForUpdate(objectWithUpdates, object);

		final LinkedList<AttributePath> keyAttributePaths = objectWithUpdates.getKeyAttributePaths();

		object.setKeyAttributePaths(keyAttributePaths);

		final AttributePath valueAttributePath = objectWithUpdates.getValueAttributePath();

		object.setValueAttributePath(valueAttributePath);

		return object;
	}

	@Override
	public void reset() {

		attributePathsResourceTestUtils.reset();
	}
}
