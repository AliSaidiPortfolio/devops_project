package com.esprit.examen.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import com.esprit.examen.repositories.StockRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Stock;
@SpringBootTest
public class StockServiceMockTest {

    @Mock
    StockRepository stockRepository;
    @InjectMocks
    StockServiceImpl stockService;
    //mock assure le type de retour qu on veut par la methode
    @Test
    public void testRetrieveStockById(){


        Stock s =new Stock("test stock",70,700);
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        assertNotNull(stockService.retrieveStock(1L));

    }
    @Test
    public void testRetrieveAllStock()  {
        Stock s =new Stock("test stock",70,700);
        List<Stock> stocks = new ArrayList<>();
        stocks.add(s);
        Mockito.when(stockRepository.findAll()).thenReturn(stocks);
        List<Stock> result = stockService.retrieveAllStocks();
        assertEquals(result.size(), 1);
    }

    @Test
    public void testAddStock(){


        Stock s =new Stock("test stock",70,700);
        Mockito.when(stockRepository.save(s)).thenReturn(s);
        stockService.addStock(s);
        assertTrue(true);
    }

    @Test
    public void testUpdateStock(){


        Stock s =new Stock("test stock",70,700);
        Mockito.when(stockRepository.save(s)).thenReturn(s);
        stockService.updateStock(s);
        assertTrue(true);
    }
    @Test
    public void testDeleteStock()  {
        Mockito.doNothing().when(stockRepository).deleteById(1l);
        stockService.deleteStock(1l);
        assertTrue(true);
    }


//////////////////////////mock///////////////////////////






}
