package com.poly;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.poly.model.Contact;
import com.poly.model.student2;

public class Jackson1 {
	public static void main(String[] args) throws Exception {
//		demo1();
//		demo2();
//		demo3();
//		demo4();
//		demo5();
		demo6();
	}

	private static void demo6() throws Exception{
		// TODO Auto-generated method stub
		Map<String, Object> contact = new HashMap<String, Object>();
		contact.put("email", "vana@gmail.com");
		contact.put("phone", "0192919");
		List<String> sub = Arrays.asList("WEB205","COM108");
		Map<String, Object> st = new HashMap<String, Object>();
		st.put("'name", "van a");
		st.put("marks", 9.1);
		st.put("gender", true);
		st.put("contact", contact);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(st);
		System.out.println(json);
		mapper.writeValue(System.out, st);
		mapper.writeValue(new File("D:\\TÀI LIEU HOC\\TÀI LIEU HOC\\java 6\\lab1.json"), st);
	}

	private static void demo5() throws IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode st = mapper.createObjectNode();
		st.put("name", "van a");
		st.put("marks", 9.0);
		st.put("gender", true);
		ObjectNode contact = st.putObject("contact");
		contact.put("email", "vana@gmail.com");
		contact.put("phone", "02192031");
		ArrayNode sub = st.putArray("subjects");
		sub.add("WEB205");
		sub.add("COM108");
		String json = mapper.writeValueAsString(st);
		mapper.writeValue(System.out, st);
		mapper.writeValue(new File("D:\\TÀI LIEU HOC\\TÀI LIEU HOC\\java 6\\lab1.json"), st);
	}

	private static void demo4() throws Exception{
		// TODO Auto-generated method stub
		String json ="D:\\TÀI LIEU HOC\\TÀI LIEU HOC\\java 6\\demo\\src\\main\\resources\\students.json";
		TypeReference<List<student2>> type = new TypeReference<List<student2>>() {};
		ObjectMapper mapper = new ObjectMapper();
		List<student2> st = mapper.readValue(new File(json), type);
		st.forEach(std -> {
			System.out.println("name: "+std.getName());
		});
	}

	private static void demo3() throws Exception {
		// TODO Auto-generated method stub
		String json ="D:\\TÀI LIEU HOC\\TÀI LIEU HOC\\java 6\\demo\\src\\main\\resources\\student.json";
		ObjectMapper mapper = new ObjectMapper();
		student2 st = mapper.readValue(new File(json), student2.class);
		System.out.println("name: "+st.getName());
		System.out.println("marks: "+st.getMarks());
		System.out.println("gender: "+st.getGender());
		Contact contact= st.getContact();
		System.out.println("email: "+contact.getEmail());
		System.out.println("phone: "+contact.getPhone());
		List<String> sub = st.getSubject();
		sub.forEach(subj -> {
			System.out.println("subject: "+subj);
		});
	}

	private static void demo2() throws Exception{
		// TODO Auto-generated method stub
		String json ="D:\\TÀI LIEU HOC\\TÀI LIEU HOC\\java 6\\demo\\src\\main\\resources\\students.json";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode students = mapper.readTree(new File(json));
		students.iterator().forEachRemaining(a -> {
			System.out.println("name: "+ a.get("name").asText());
		});
	}

	private static void demo1() throws Exception {
		// TODO Auto-generated method stub
		String json ="D:\\TÀI LIEU HOC\\TÀI LIEU HOC\\java 6\\demo\\src\\main\\resources\\student.json";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode student = mapper.readTree(new File(json));
		System.out.println("mane: "+student.get("name").asText());
		System.out.println("marks: "+student.get("marks").asDouble());
		System.out.println("gender: "+student.get("gender").asBoolean());
		System.out.println("email: "+student.get("contact").get("email").asText());
		System.out.println("phone: "+student.findValue("phone").asText());
		student.get("subject").iterator().forEachRemaining(subject -> {
			System.out.println("subject: "+subject.asText());
		});
	}
}
