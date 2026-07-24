# PRG381-Project
Task B - Desktop Application. 
A desktop application built for university cleaning staff to manage materials, suppliers, 
cleaners, and stock issuances, with login/registration and role-based access 
(Storekeeper and Supervisor).
Steps to get this program working:
1. Once the program is installed to your device, download and connect the latest PostgreSQL Driver to the program.
2. Make a clean build of this program to decrease the chance of any random errors occuring.
3. Create a PostgreSQL Database with these 5 tables: Users, Materials, Suppliers, Cleaners, Stock Issuance.
4. In Users the fields needed are: UserID (int, auto-generated), Firstname (string), Lastname (string), Email (string), Password (string), Role (string — "Storekeeper" or "Supervisor").
5. In Materials the fields needed are: MaterialID (int, auto-generated), Name (string), Quantity (int) and Reorder Level (int).
6. In Suppliers the fields needed are: SupplierID (int, auto-generated), Name (string), Company Name (string), Contact Number (int), Email (string).
7. In Cleaners the fields needed are: CleanerID (int, auto-generated), Name (string), Company Name (string), Contact Number (int), Email (string).
8. In Stock Issuance the fields needed are: ID (int, auto-generated), Cleaner ID (int), Material ID (int), Quantity Issued (int), Issue Date (date/time).

## Database tables

**users**
- id (SERIAL, primary key)
- first_name (varchar)
- last_name (varchar)
- email (varchar, unique)
- password (varchar)
- role (varchar — "Storekeeper" or "Supervisor")

**materials**
- material_id (SERIAL, primary key)
- material_name (varchar)
- quantity (int)
- reorder_level (int)

**cleaners**
- cleaner_id (SERIAL, primary key)
- cleaner_name (varchar)
- company_name (varchar)
- contact_number (bigint)
- email (varchar)

**suppliers**
- supplier_id (SERIAL, primary key)
- supplier_name (varchar)
- company_name (varchar)
- contact_number (bigint)
- email (varchar)

**stock_issuance**
- id (SERIAL, primary key)
- cleaner_id (int, references cleaners)
- material_id (int, references materials)
- quantity_issued (int)
- issue_date (timestamp)

## Features implemented

- Login, Registration, and Logout
- Role-based access (Storekeeper / Supervisor) — Supervisor-only permissions on 
  higher-risk actions (e.g. deleting materials)
- Dashboard with live counts: total materials, low-stock items, total cleaners, 
  recent stock issuances
- Materials Management (Add/View/Update/Delete)
- Suppliers Management (Add/View/Update/Delete)
- Cleaners Management (Add/View/Update/Delete)
- Stock Issuance (issues materials to cleaners, deducts stock automatically, 
  blocks issuing more than what's available)
- Reports: Inventory Report, Low-Stock Report, Issuance History, Material Usage Report
- Dark/Light theme toggle across all screens

## Notes

- Since everyone was working against their own local Postgres database, some field 
  names had to be standardised across the group as modules got merged (documented in 
  commit messages).
- Validation (required fields, duplicate email checks, numeric checks, negative stock 
  prevention) is handled per-module directly in the Controller classes rather than one 
  shared validator, to keep each module's logic self-contained.

 ## Github Repository
  https://github.com/ClarissaBierman/PRG381-Project
