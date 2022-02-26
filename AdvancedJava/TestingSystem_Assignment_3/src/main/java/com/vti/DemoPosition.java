package com.vti;

import java.util.List;

import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;
import com.vti.repository.PositionRepository;

public class DemoPosition {
	public static void main(String[] args) {
		PositionRepository repository = new PositionRepository();

		System.out.println("***********GET ALL POSITIONS***********");

		List<Position> positions = repository.getAllPositions();

		for (Position position : positions) {
			System.out.println(position);
		}

		System.out.println("\n\n***********GET POSITION BY ID***********");

		Position positionById = repository.getPositionByID((short) 2);
		System.out.println(positionById);

//		System.out.println("\n\n***********GET GROUP BY NAME***********");
//
//		Group groupByName = repository.getGroupByName("VTI Creator");
//		System.out.println(groupByName);
//
		System.out.println("\n\n***********CREATE POSITION***********");

		Position positionCreate = new Position();
		positionCreate.setName(PositionName.PM);
		repository.createPosition(positionCreate);
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
