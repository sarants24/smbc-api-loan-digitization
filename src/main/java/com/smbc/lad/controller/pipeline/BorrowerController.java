package com.smbc.lad.controller.pipeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.BorrowerInformation;
import com.smbc.lad.service.BorrowerService;

/**
 * @author Saravanan T
 * @since April 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. To get the Primary Borrower Info
 * 2. To add/update the Primary Borrower Info
 * 3. To get the list of additional Borrower Info
 * 4. To get the details single additional Borrower Info for the given borrower id
 * 5. To add additional Borrower Info
 * 6. To update additional Borrower Info
 * 7. To delete additional Borrower Info
 */
@RestController
public class BorrowerController {

	@Autowired
	private BorrowerService borrowerService;
	
	//Primary Borrower
	
	/**
	 * To fetch primary Borrower info details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/borrower/primary/{pipelineId}", method=RequestMethod.GET)
	public BorrowerInformation getPrimaryBorrowerInfoById(@PathVariable int pipelineId) throws Exception 
	{
		
		BorrowerInformation borrowerInformation = borrowerService.getBorrowerInfoById(pipelineId);
				
		return borrowerInformation;
	}
	
	/**
	 * To update primary Borrower info details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/borrower/primary/{pipelineId}", method=RequestMethod.POST)
	public String updateBorrowerInformationById(@PathVariable int pipelineId, @RequestBody BorrowerInformation borrowerInformation) throws Exception 
	{
		String status =borrowerService.updateBorrowerInfoById(pipelineId,borrowerInformation);
				
		return status;
	}
	
	
	//Additional Borrower
	
	/**
	 * To fetch additional Borrower info details for the given application number
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/borrower/additional/all/{pipelineId}", method=RequestMethod.GET)
	public List<BorrowerInformation> getAdditionalBorrowerInfoById(@PathVariable int pipelineId) throws Exception 
	{
		List<BorrowerInformation> borrowerInformationList = borrowerService.getAddtlBorrowerInfoByPipelineId(pipelineId);
				
		return borrowerInformationList;
	}
	
	/**
	 * To fetch additional Borrower info details for the given additional borrower id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/borrower/additional/{addtlBorrowerId}", method=RequestMethod.GET)
	public BorrowerInformation getAdditionalBorrowerInfoByBorrowerId(@PathVariable int addtlBorrowerId) throws Exception 
	{
		
		BorrowerInformation borrowerInformation = borrowerService.getAddtlBorrowerInfoByBorrowerId(addtlBorrowerId);
				
		return borrowerInformation;
	}

	/**
	 * To add additional Borrower info details for the borrower id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/borrower/additional/pipeline/{pipelineId}", method=RequestMethod.POST)
	public String addBorrowerInfoById(@PathVariable int pipelineId, @RequestBody BorrowerInformation borrowerInformation) throws Exception 
	{
	
		String status = borrowerService.addAdditinalBorrowerInfoById(pipelineId,borrowerInformation);
				
		return status;
	}
	
	
	/**
	 * To update additional Borrower info details for the borrower id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/borrower/additional/{addtionalBorrowerId}", method=RequestMethod.POST)
	public String updateBorrowerInfoById(@PathVariable int addtionalBorrowerId, @RequestBody BorrowerInformation borrowerInformation) throws Exception 
	{
	
		String status =borrowerService.updateAdditinalBorrowerInfoById(addtionalBorrowerId,borrowerInformation);
				
		return status;
	}
	

	/**
	 * To delete additional Borrower info details for the borrower id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/borrower/additional/{addtionalBorrowerId}", method=RequestMethod.DELETE)
	public String deleteAdditioanlBorrowerInfoById(@PathVariable int addtionalBorrowerId) throws Exception 
	{
	
		String status = borrowerService.deleteAdditinalBorrowerInfoById(addtionalBorrowerId);
				
		return status;
	}
}
