package de.avgl.dmp.converter.flow.test;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author tgaengler
 */
public class MABXMLTransformationFlowWOTransformationComponentTest extends AbstractXMLTransformationFlowTest {

	public MABXMLTransformationFlowWOTransformationComponentTest() {

		super("task.wo.transformationcomponent.json", "task-result.wo.transformationcomponent.json", "datensatz", "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd", "test-mabxml.xml");
	}

	@Override
	protected void compareResults(final String expectedResultJSONString, final String actualResultJSONString) throws Exception {
		
		final ArrayNode expectedJSONArray = objectMapper.readValue(expectedResultJSONString, ArrayNode.class);
		final ObjectNode expectedJSON = (ObjectNode) expectedJSONArray.get(0).get("record_data");
		final String finalExpectedJSONString = objectMapper.writeValueAsString(expectedJSON);

		final ArrayNode actualJSONArray = objectMapper.readValue(actualResultJSONString, ArrayNode.class);
		final ObjectNode actualJSON = (ObjectNode) actualJSONArray.get(0).get("record_data");
		final String finalActualJSONString = objectMapper.writeValueAsString(actualJSON);

		assertEquals(finalExpectedJSONString.length(), finalActualJSONString.length());
	}
}
