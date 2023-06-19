package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce){
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier paks2 = new Supplier(1,"MonsterFlovers", "Little or big monsters - choose one for you");
        supplierDataStore.add(paks2);
        Supplier nutKing = new Supplier(2,"Phil Your Emotions", "The best philodendron importer");
        supplierDataStore.add(nutKing);
        Supplier linux = new Supplier(3,"Pots with Dots", "Handmade pots and more for your flowers");
        supplierDataStore.add(linux);
        Supplier gymBro  = new Supplier(3,"GreenBus", "Flowers and everything for them");
        supplierDataStore.add(gymBro);



        //setting up a new product category
        ProductCategory kernel = new ProductCategory(1, "Monsteras", "Plants", "Every kind of holes in monsteras - choose one for you");
        productCategoryDataStore.add(kernel);

        ProductCategory edibleNuts = new ProductCategory(2, "Philodendrons", "Plants", "Tropical plants for your home jungle");
        productCategoryDataStore.add(edibleNuts);

        ProductCategory nuclearCore = new ProductCategory(3, "Pots", "Pots", "Choose the perfect pot fot ypu plant");
        productCategoryDataStore.add(nuclearCore);

        ProductCategory nutrients = new ProductCategory(4, "Plant Stuff", "Stuff", "Make your plants great again");
        productCategoryDataStore.add(nutrients);

        //setting up products and printing it
        productDataStore.add(new Product(1,"Monstera Deliciosa", 10.5f, "USD", "Simply the best.", kernel, linux));
        productDataStore.add(new Product(2,"Monstera Adansonii", 5.5f, "USD", "Little monkey in your house.", kernel, linux));
        productDataStore.add(new Product(3,"Rhaphidophora Tetrasperma", 20.0f, "USD", "Really smart plant.", kernel, linux));
        productDataStore.add(new Product(4,"Monstera Deliciosa Thai", 150.0f, "USD", "Monstera for real collector.", kernel, linux));

        productDataStore.add(new Product(5,"Philodendron Pink Princess", 90.0f, "USD", "Must have collector's plant.", edibleNuts, nutKing));
        productDataStore.add(new Product(6,"Philodendron Melonachrysum", 85.0f, "USD", "A real rarity can be yours.", edibleNuts, nutKing));
        productDataStore.add(new Product(7,"Philodendron Xandu", 15.5f, "USD", "Let's make a jungle!", edibleNuts, nutKing));
        productDataStore.add(new Product(8,"Philodendron Scandens", 12.0f, "USD", "Little but with big heart", edibleNuts, nutKing));

        productDataStore.add(new Product(9,"Brown pot", 20.0f, "USD", "Clay brow.n pot with stand.", nuclearCore, paks2));
        productDataStore.add(new Product(10,"Round white vase", 30.5f, "USD", "Made of high quality glass.", nuclearCore, paks2));
        productDataStore.add(new Product(11,"Straw pot", 10.0f, "USD", "Simple weave flower pot cover.", nuclearCore, paks2));
        productDataStore.add(new Product(12,"Metal pot", 5.5f, "USD", "Simple and solid choice.", nuclearCore, paks2));

        productDataStore.add(new Product(13,"Soil mixture", 20.0f, "USD", "The best soil for philodendrons.", nutrients, gymBro));
        productDataStore.add(new Product(14,"Fertilizers", 10.0f, "USD", "Your plant will be greener than fresh grass.", nutrients, gymBro));
        productDataStore.add(new Product(15,"Handheld humidifier", 5.0f, "USD", "Give your plants more moisture.", nutrients, gymBro));
        productDataStore.add(new Product(16,"Pest spray", 15.5f, "USD", "Little insects won't be your problem anymore.", nutrients, gymBro));

    }

}
