import org.example.models.AgeCategory;
import org.example.models.Medicine;
import org.example.models.Pharmacy;
import org.example.service.PharmacyServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PharmacyServiceImplTest {
    @InjectMocks
    private PharmacyServiceImpl pharmacyService;

    @Mock
    private Pharmacy pharmacy;

    @Test
    void numberOfPromotedMedicinesByAgeCategory(){
        //given
        Medicine medicine1 = mock(Medicine.class);
        Medicine medicine2 = mock(Medicine.class);
        Medicine medicine3 = mock(Medicine.class);
        Medicine medicine4 = mock(Medicine.class);

        when(medicine1.getAgeCategory()).thenReturn(AgeCategory.ADULTS);
        when(medicine2.getAgeCategory()).thenReturn(AgeCategory.ADULTS);
        when(medicine3.getAgeCategory()).thenReturn(AgeCategory.CHILDREN);
        when(medicine4.getAgeCategory()).thenReturn(AgeCategory.TEENAGERS);

        Set<Medicine> medicines = new HashSet<>();
        medicines.add(medicine1);
        medicines.add(medicine2);
        medicines.add(medicine3);
        medicines.add(medicine4);

        when(pharmacy.getPromotedMedicines()).thenReturn(medicines);

        long expectedNumberOfPromotedMedicinesByAgeCategory = 2;

        //when
        long actualNumberOfPromotedMedicinesByAgeCategory =
                pharmacyService.numberOfPromotedMedicinesByAgeCategory(pharmacy, AgeCategory.ADULTS);

        //then
        assertEquals(expectedNumberOfPromotedMedicinesByAgeCategory, actualNumberOfPromotedMedicinesByAgeCategory);
    }

    @Test
    void MedicinesSellingPriceTotalValue(){
        //given
        Medicine medicine1 = mock(Medicine.class);
        Medicine medicine2 = mock(Medicine.class);

        Map<Medicine, Double> medicinesSellingPrice = new HashMap<>();
        medicinesSellingPrice.put(medicine1, 10.2);
        medicinesSellingPrice.put(medicine2, 5.4);

        when(pharmacy.getMedicinesSellingPrice()).thenReturn(medicinesSellingPrice);

        double expectedTotalValue = 15.6;

        //when
        double actualTotalValue = pharmacyService.medicinesSellingPriceTotalValue(pharmacy);

        //then
        assertEquals(expectedTotalValue, actualTotalValue);

    }
}
