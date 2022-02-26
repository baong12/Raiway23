package com.vti;

import java.util.List;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

public class Program {
	public static void main(String[] args) {
		GroupRepository repository = new GroupRepository();

		System.out.println("***********GET ALL GROUPS***********");

		List<Group> groups = repository.getAllGroups();

		for (Group group : groups) {
			System.out.println(group);
		}

		System.out.println("\n\n***********GET GROUP BY ID***********");

		Group groupById = repository.getGroupByID((short) 2);
		System.out.println(groupById);

//		System.out.println("\n\n***********GET GROUP BY NAME***********");
//
//		Group groupByName = repository.getGroupByName("VTI Creator");
//		System.out.println(groupByName);
//
//		System.out.println("\n\n***********CREATE GROUP***********");
//
//		Group groupCreate = new Group();
//		groupCreate.setName("waiting");
//		repository.createGroup(groupCreate);
//
//		System.out.println("\n\n***********UPDATE GROUP 1***********");
//
//		repository.updateGroup((short) 3, "Security");
//
//		System.out.println("\n\n***********UPDATE GROUP 2***********");
//
//		Group groupUpdate = new Group();
//		groupUpdate.setId((short) 2);
//		groupUpdate.setName("Dev");
//		repository.updateGroup(groupUpdate);
//
//		System.out.println("\n\n***********DELETE GROUPS***********");
//		repository.deleteGroup((short) 2);
//
//		System.out.println("***********CHECK GROUP EXISTS BY ID***********");
//		System.out.println(repository.isGroupExistsByID((short) 1));
//
//		System.out.println("***********CHECK GROUP EXISTS BY NAME***********");
//		System.out.println(repository.isGroupExistsByName("Management"));
	}
}
