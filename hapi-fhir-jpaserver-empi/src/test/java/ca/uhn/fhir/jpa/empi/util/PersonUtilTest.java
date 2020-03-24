package ca.uhn.fhir.jpa.empi.util;

import ca.uhn.fhir.context.FhirContext;
import org.hl7.fhir.instance.model.api.IIdType;
import org.hl7.fhir.r4.model.Person;
import org.hl7.fhir.r4.model.Reference;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonUtilTest {
	public static final FhirContext ourFhirContext = FhirContext.forR4();
	public static final String PATIENT_1 = "Patient/1";
	public static final String PATIENT_2 = "Patient/2";

	@Test
	public void testGetLinks() {
		Person person = new Person();
		person.addLink().setTarget(new Reference(PATIENT_1));
		person.addLink().setTarget(new Reference(PATIENT_2));
		List<IIdType> links = PersonUtil.getLinks(ourFhirContext, person);
		assertEquals(2, links.size());
		assertEquals(PATIENT_1, links.get(0).getValue());
		assertEquals(PATIENT_2, links.get(1).getValue());
	}
}