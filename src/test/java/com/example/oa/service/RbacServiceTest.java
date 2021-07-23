package com.example.oa.service;

import com.example.oa.entity.Node;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RbacServiceTest {
	private RbacService rbacService = new RbacService();
	@Test
	public void selectNodeByUserId() {
		List<Node> list = rbacService.selectNodeByUserId(3l);
		for (Node n: list) {
			System.out.println(n.getNodeName());
		}
	}
}