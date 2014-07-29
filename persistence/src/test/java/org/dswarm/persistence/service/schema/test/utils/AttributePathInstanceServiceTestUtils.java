package org.dswarm.persistence.service.schema.test.utils;

import org.junit.Assert;

import org.dswarm.persistence.model.schema.Attribute;
import org.dswarm.persistence.model.schema.AttributePath;
import org.dswarm.persistence.model.schema.AttributePathInstance;
import org.dswarm.persistence.model.schema.AttributePathInstanceType;
import org.dswarm.persistence.model.schema.proxy.ProxyAttributePathInstance;
import org.dswarm.persistence.service.schema.AttributePathInstanceService;
import org.dswarm.persistence.service.test.utils.BasicDMPJPAServiceTestUtils;

public abstract class AttributePathInstanceServiceTestUtils<POJOCLASSPERSISTENCESERVICE extends AttributePathInstanceService<PROXYPOJOCLASS, POJOCLASS>, PROXYPOJOCLASS extends ProxyAttributePathInstance<POJOCLASS>, POJOCLASS extends AttributePathInstance>
		extends BasicDMPJPAServiceTestUtils<POJOCLASSPERSISTENCESERVICE, PROXYPOJOCLASS, POJOCLASS> {

	private final AttributePathServiceTestUtils	attributePathServiceTestUtils;

	public AttributePathInstanceServiceTestUtils(final Class<POJOCLASS> pojoClassArg,
			final Class<POJOCLASSPERSISTENCESERVICE> persistenceServiceClassArg) {

		super(pojoClassArg, persistenceServiceClassArg);

		attributePathServiceTestUtils = new AttributePathServiceTestUtils();
	}

	/**
	 * {@inheritDoc} <br />
	 * Assert both object's {@link AttributePathInstanceType}s are equal. <br />
	 * Assert that either both objects have no {@link AttributePath}s, or (in case {@link AttributePath}s are present), both
	 * {@link AttributePath} have either no {@link Attribute}s or the same number of {@link Attribute}s and the {@link Attribute}s
	 * are equal regarding id and name.
	 * 
	 * @param expectedObject
	 * @param actualObject
	 */
	@Override
	public void compareObjects(final POJOCLASS expectedObject, final POJOCLASS actualObject) {

		super.compareObjects(expectedObject, actualObject);

		Assert.assertEquals("the " + pojoClassName + " attribute path instance types should be equal", expectedObject.getAttributePathInstanceType(),
				actualObject.getAttributePathInstanceType());

		if (expectedObject.getAttributePath() == null) {

			Assert.assertNull("the actual attribute path instance should be null", actualObject.getAttributePath());

		} else {

			attributePathServiceTestUtils.compareObjects(expectedObject.getAttributePath(), actualObject.getAttributePath());
		}
	}

	/**
	 * {@inheritDoc}<br/>
	 */
	@Override
	protected POJOCLASS prepareObjectForUpdate(final POJOCLASS objectWithUpdates, final POJOCLASS object) {

		super.prepareObjectForUpdate(objectWithUpdates, object);

		object.setAttributePath(objectWithUpdates.getAttributePath());

		return object;
	}

	@Override
	public void reset() {

		attributePathServiceTestUtils.reset();
	}
}
