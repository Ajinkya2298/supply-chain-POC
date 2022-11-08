package com.kotlinmonorepo.dropwizardapp.com.kotlinmonorepo.dropwizardapp.services.masterdata

import com.kotlinmonorepo.dropwizardapp.com.kotlinmonorepo.dropwizardapp.entities.Product
import com.kotlinmonorepo.dropwizardapp.com.kotlinmonorepo.dropwizardapp.entities.ProductType


object ProductTypeService {
     val dairy = ProductType("PT_Dairy","Dairy")
     val poultry = ProductType("PT_Poultry","Poultry")
     val freshProduce = ProductType("PT_FreshProduce","Fresh Produce")
}
