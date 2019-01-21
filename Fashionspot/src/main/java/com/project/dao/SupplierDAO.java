package com.project.dao;

import java.util.List;

import com.project.model.Supplier;

public interface SupplierDAO 
{
 public boolean addSupplier(Supplier supplier);
 public boolean deleteSupplier(Supplier supplier);
 public boolean updatesupplier(Supplier supplier);
 public List<Supplier> listSuppliers();
 public Supplier getSupplier(int supplierID);
}
