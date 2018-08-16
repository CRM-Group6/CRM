package com.crm;

import com.crm.entity.Contract;
import com.crm.enums.verify_enum.VerifyTypeEnum;
import com.crm.service.contract_service.ContractService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrmApplicationTests {
	@Autowired
	ContractService contractService;
	@Test
	public void contextLoads() {
//		Contract contract = new Contract();
//		contract.setId((long) 123456);
//		contract.setClientId((long)123);
//		contract.setSalesmanId((long) 12345678);
//		contract.setVerifyStatus(VerifyTypeEnum.CHECKED.getCode());
//		Contract result = contractService.insert(contract);
//		Assert.assertNotNull(result);
	}

}
