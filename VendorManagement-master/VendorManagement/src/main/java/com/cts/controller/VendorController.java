package com.cts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Vendor;
import com.cts.service.VendorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/vendor")
@Api(value = "The Vendor Controller", description = "Rest controller for vendor")
public class VendorController {

	@Autowired
	VendorService service;

	@ApiOperation(value = "Add a vendor",
			consumes = "A new vendor is JSON",
			notes = "Hit this URL to insert a new vendor's details"
			)
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	void addVendor(@RequestBody Vendor vendor) {
		service.addVendor(vendor);
	}

	@ApiOperation(value = "Delete a vendor",
			consumes = "An existing vendor id",
			notes = "Hit this URL to delete a vendor's details"
			)
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{vendorId}")
	void deleteVendorById(@PathVariable long vendorId) {
		service.deleteVendor(vendorId);
	}

	@ApiOperation(value = "Update a vendor's details",
			consumes = "An existing vendor in JSON",
			notes = "Hit this URL to update a vendor's details"
			)
	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	void updateVendor(@RequestBody Vendor vendor) {
		service.updateVendor(vendor);

	}

	@ApiOperation(value = "Retrieve a vendor's details",
			produces = "A vendor's details if it exists",
			notes = "Hit this URL to get a vendor's details"
			)
	@RequestMapping(method = RequestMethod.GET, value = "/get/{vendorId}")
	Optional<Vendor> getVendorById(@PathVariable long vendorId) {
		return service.getVendorById(vendorId);
	}
	
	@ApiOperation(value = "Get all vendors",
			produces = "A list of vendors",
			notes = "Hit this URL to get all vendors details"
			)
	@RequestMapping(method = RequestMethod.GET, value = "/getAll")
	List<Vendor> getAll(){
		return service.getAll();
	}
}
