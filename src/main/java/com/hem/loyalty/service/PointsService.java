package com.hem.loyalty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hem.common.util.SequenceGeneratorService;
import com.hem.loyalty.model.Address;
import com.hem.loyalty.model.Points;
import com.hem.loyalty.repository.PointsRepository;

@Service
public class PointsService {


	@Autowired
	private SequenceGeneratorService seqService;


	
	@Autowired
	PointsRepository pointsRepository;
	
	@Autowired
	ICustomerService customerService;
	
	public Points create(Points points) {
		points.setId(seqService.generateSequence(Points.SEQUENCE_NAME));
		pointsRepository.save(points);
		customerService.savePointsToCustomer(points);
		return points;
	}
	
}
