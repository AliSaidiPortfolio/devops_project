package com.esprit.examen.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import com.esprit.examen.repositories.StockRepository;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
//	@Autowired
//	IStockService stockService;
	@Mock
	StockRepository stockRepository;
	@InjectMocks
	StockServiceImpl stockService;
	@Test
	public void testAddStock() {
	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		Stock s = new Stock(1L,"stock test",10,100 );
		Mockito.when(stockRepository.save(s)).thenReturn(s);
		Stock savedStock= stockService.addStock(s);
		assertNotNull(savedStock.getIdStock());

	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
//		assertNotNull(savedStock.getLibelleStock());
//		stockService.deleteStock(savedStock.getIdStock());
		
	}
//	@Test
//	public void testUpdateStock() {
//
//		Stock s = new Stock("stock test",10,100);
//		Stock savedStock= stockService.addStock(s);
//		Stock updateStock=stockService.updateStock(new Stock( "stock test",60,10));
//
//		assertNotNull(updateStock.getIdStock());
//		assertSame(60, updateStock.getQte());
//		assertTrue(updateStock.getQteMin()<11);
//		assertSame(savedStock.getIdStock(), updateStock.getQte());
//		stockService.deleteStock(savedStock.getIdStock());
//
//	}

//	@Test
//	public void testAddStockOptimized() {
//
//		Stock s = new Stock("stock test",10,100);
//		Stock savedStock= stockService.addStock(s);
//		assertNotNull(savedStock.getIdStock());
//		assertSame(10, savedStock.getQte());
//		assertTrue(savedStock.getQteMin()>0);
//		stockService.deleteStock(savedStock.getIdStock());
//
//	}

//	@Test
//	public void testDeleteStock() {
//		Stock s = new Stock("stock test",30,60);
//		Stock savedStock= stockService.addStock(s);
//		stockService.deleteStock(savedStock.getIdStock());
//		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
//	}

	@Test
	public void testRetrieveAllStocks(){
		List<Stock> stocks = new ArrayList<>();
		Stock s1 = new Stock(1L,"stock test1",30,60);
		Stock s2= new Stock(2L,"stock test2",60,120);
		stocks.add(s1);
		stocks.add(s2);
		Mockito.when(stockRepository.findAll()).thenReturn(stocks);

		List<Stock> allStocks = stockService.retrieveAllStocks();
		assertEquals(2, allStocks.size());
		//stockService.deleteStock(savedStock.getIdStock());
	}

	@Test
	public void testRetrieveStockById(){

		List<Stock> stocks = new ArrayList<>();
		Stock s1 = new Stock(1L,"stock test1",30,60);
		Stock s2= new Stock(2L,"stock test2",60,120);
		stocks.add(s1);
		stocks.add(s2);
		Mockito.when(stockRepository.findById(1l)).thenReturn(Optional.of(s1));
		Mockito.when(stockRepository.findById(2l)).thenReturn(Optional.of(s2));
		assertSame(1L, stockService.retrieveStock(1L).getIdStock());
		assertSame(2L, stockService.retrieveStock(2L).getIdStock());

		//assertTrue(stockGet.getQteMin()>0);
		//stockService.deleteStock(stockGet.getIdStock());
	}

}
