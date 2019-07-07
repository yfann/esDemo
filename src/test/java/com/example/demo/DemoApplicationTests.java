package com.example.demo;

import com.example.demo.entity.Child;
import com.example.demo.entity.Commodity;
import com.example.demo.entity.Father;
import com.example.demo.services.CommodityService;
import com.example.demo.services.EsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private EsService esService;

	@Test
	public void contextLoads() {
		System.out.println(commodityService.count());
	}


	@Test
	public void testFatherChild(){
		String uuid=UUID.randomUUID().toString();
		Father f=new Father();
		f.setId(uuid);
		f.setName("father1");
		Child c=new Child();
		c.setName("child1");
		c.getSub().setParent(uuid);
		Child c2=new Child();
		c2.setName("child2");
		c2.getSub().setParent(uuid);
		esService.saveFather(f);
		esService.saveSon(c,uuid);
		esService.saveSon(c2,uuid);
	}

	@Test
	public void testInsert() {
		Commodity commodity = new Commodity();
		commodity.setSkuId("1501009001");
		commodity.setName("原味切片面包（10片装）");
		commodity.setCategory("101");
		commodity.setPrice(880);
		commodity.setBrand("良品铺子");
		commodityService.save(commodity);

		commodity = new Commodity();
		commodity.setSkuId("1501009002");
		commodity.setName("原味切片面包（6片装）");
		commodity.setCategory("101");
		commodity.setPrice(680);
		commodity.setBrand("良品铺子");
		commodityService.save(commodity);

		commodity = new Commodity();
		commodity.setSkuId("1501009004");
		commodity.setName("元气吐司850g");
		commodity.setCategory("101");
		commodity.setPrice(120);
		commodity.setBrand("百草味");
		commodityService.save(commodity);

	}

	@Test
	public void testDelete() {
		Commodity commodity = new Commodity();
		commodity.setSkuId("1501009002");
		commodityService.delete(commodity);
	}

	@Test
	public void testGetAll() {
		Iterable<Commodity> iterable = commodityService.getAll();
		iterable.forEach(e->System.out.println(e.toString()));
	}

	@Test
	public void testGetByName() {
		List<Commodity> list = commodityService.getByName("面包");
		System.out.println(list);
	}

	@Test
	public void testPage() {
		Page<Commodity> page = commodityService.pageQuery(0, 10, "切片");
		System.out.println(page.getTotalPages());
		System.out.println(page.getNumber());
		System.out.println(page.getContent());
	}

}
