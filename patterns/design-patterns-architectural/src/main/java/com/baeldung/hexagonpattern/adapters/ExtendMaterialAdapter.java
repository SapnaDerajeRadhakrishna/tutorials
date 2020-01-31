package com.baeldung.hexagonpattern.adapters;

import java.util.List;

import com.baeldung.hexagonpattern.domain.LibraryMaterialBorrowLogic;
import com.baeldung.hexagonpattern.domain.LibraryMaterialStatus;
import com.baeldung.hexagonpattern.domain.LibraryMaterialType;
import com.baeldung.hexagonpattern.factory.MaterialsOrderFactory;
import com.baeldung.hexagonpattern.ports.ExtendMaterialPort;

public class ExtendMaterialAdapter implements ExtendMaterialPort {

	LibraryMaterialBorrowLogic libraryMaterialBorrowLogic = MaterialsOrderFactory.getMaterialOrderProcessor();

	@Override
	public LibraryMaterialStatus processMaterialOrder(List<LibraryMaterialType> items) throws Exception {
		if (items.size() <= 0) {
			throw new Exception("No library items to process");
		}
		return libraryMaterialBorrowLogic.processMaterial(items);
	}

	@Override
	public LibraryMaterialType createItem(String item) {
		LibraryMaterialType materialType = new LibraryMaterialType();
		try {
			materialType.setItem(item);
		} catch (Exception e) {
			return null;
		}
		return materialType;
	}

}
