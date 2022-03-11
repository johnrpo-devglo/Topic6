package org.challenge.topic6.service;

import org.challenge.topic6.dao.InvoceRepository;
import org.challenge.topic6.dao.InvoceRepository2;
import org.challenge.topic6.models.Invoce;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InvoceServiceImplTest {

    @Test
    void find_Id_Company() {
        InvoceRepository repository = mock(InvoceRepository.class);
        InvoceService service = new InvoceServiceImpl(repository);

        List<Invoce> datos = Arrays.asList(new Invoce(1L, 1L, "01/01/20", 578000L),
                new Invoce(2L, 2L, "01/02/20", 155000L),
                new Invoce(3L, 3L, "01/03/20", 450000L),
                new Invoce(4L, 4L, "01/04/20", 157000L),
                new Invoce(5L, 5L, "01/05/20", 187000L));

        when(repository.findAll()).thenReturn(datos);
        Optional<Invoce> invoce = service.findInvoce(3L);

        assertTrue(invoce.isPresent());
        assertEquals(003L, invoce.orElseThrow().getId());
        assertEquals(3L, invoce.orElseThrow().getIdBanco());
        assertEquals("01/03/20", invoce.orElseThrow().getExpire());
        assertEquals(450000L, invoce.orElseThrow().getPayBill());
    }
}