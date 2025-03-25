package org.monopoly.Model.GameTiles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests to check whether the proper actions show for each element space when landed on.
 *
 * @author shifmans
 */
public class ElementSpacesLandOnTests {
    @Test
    public void testGoSpaceLandOnCorrectActions() {
        GoSpace space = new GoSpace();

        assertEquals("Collect $200", space.landOn());
    }

    @Test
    public void testGoSpaceLandOnIncorrectActions() {
        GoSpace space = new GoSpace();

        assertNotEquals("Property Name: Boardwalk\n" +
                "Color Set: Dark Blue\n" +
                "Purchase Price: $400\n" +
                "Rent (without houses/hotels): $50\n" +
                "Rent with 1 House: $200\n" +
                "Rent with 2 Houses: $600\n" +
                "Rent with 3 Houses: $1,400\n" +
                "Rent with 4 Houses: $1,800\n" +
                "Rent with Hotel: $2,000\n" +
                "Mortgage Value: $200\n" +
                "Houses: Can build 4 houses\n" +
                "Hotel: Can build 1 hotel", space.landOn());
    }


    @Test
    public void testPropertySpaceLandOnCorrectActions() {
        PropertySpace space = new PropertySpace("Property Space", "", 0,0, "");

        assertEquals("Property Name: Boardwalk\n" +
                "Color Set: Dark Blue\n" +
                "Purchase Price: $400\n" +
                "Rent (without houses/hotels): $50\n" +
                "Rent with 1 House: $200\n" +
                "Rent with 2 Houses: $600\n" +
                "Rent with 3 Houses: $1,400\n" +
                "Rent with 4 Houses: $1,800\n" +
                "Rent with Hotel: $2,000\n" +
                "Mortgage Value: $200\n" +
                "Houses: Can build 4 houses\n" +
                "Hotel: Can build 1 hotel", space.landOn());
    }

    @Test
    public void testPropertySpaceLandOnIncorrectActions() {
        PropertySpace space = new PropertySpace("Property Space", "", 0,0, "");


        assertNotEquals("Draw a card from the deck", space.landOn());
    }

    @Test
    public void testCommunityChestSpaceLandOnCorrectActions() {
        CommunityChestSpace space = new CommunityChestSpace();

        assertEquals("Draw a card from the deck", space.landOn());
    }

    @Test
    public void testCommunityChestSpaceLandOnIncorrectActions() {
        CommunityChestSpace space = new CommunityChestSpace();

        assertNotEquals("Return a card to the deck", space.landOn());
    }

    @Test
    public void testChanceSpaceLandOnCorrectActions() {
        ChanceSpace space = new ChanceSpace();

        assertEquals("Draw a card from the deck", space.landOn());
    }

    @Test
    public void testChanceSpaceLandOnIncorrectActions() {
        ChanceSpace space = new ChanceSpace();

        assertNotEquals("Pay $50 or roll doubles to get out of jail", space.landOn());
    }

    @Test
    public void testJailSpaceLandOnCorrectActions() {
        JailSpace space = new JailSpace();

        assertEquals("Pay $50 or roll doubles to get out of jail", space.landOn());
    }

    @Test
    public void testJailSpaceLandOnIncorrectActions() {
        JailSpace space = new JailSpace();

        assertNotEquals("Property Name: Reading Railroad\n" +
                "Color Set: None (Railroad)\n" +
                "Purchase Price: $200\n" +
                "Rent (without houses/hotels): $25\n" +
                "Rent with 1 Railroad Owned: $25\n" +
                "Rent with 2 Railroads Owned: $50\n" +
                "Rent with 3 Railroads Owned: $100\n" +
                "Rent with 4 Railroads Owned: $200\n" +
                "Mortgage Value: $100\n" +
                "Houses: Cannot build houses or hotels\n" +
                "Hotel: Cannot build hotels", space.landOn());
    }

    @Test
    public void testRailroadSpaceLandOnCorrectActions() {
        RailroadSpace space = new RailroadSpace();

        assertEquals("Property Name: Reading Railroad\n" +
                "Color Set: None (Railroad)\n" +
                "Purchase Price: $200\n" +
                "Rent (without houses/hotels): $25\n" +
                "Rent with 1 Railroad Owned: $25\n" +
                "Rent with 2 Railroads Owned: $50\n" +
                "Rent with 3 Railroads Owned: $100\n" +
                "Rent with 4 Railroads Owned: $200\n" +
                "Mortgage Value: $100\n" +
                "Houses: Cannot build houses or hotels\n" +
                "Hotel: Cannot build hotels", space.landOn());
    }

    @Test
    public void testRailroadSpaceLandOnIncorrectActions() {
        RailroadSpace space = new RailroadSpace();

        assertNotEquals("Take a rest, you don't have to do anything", space.landOn());
    }

    @Test
    public void testFreeParkingSpaceLandOnCorrectActions() {
        FreeParkingSpace space = new FreeParkingSpace();

        assertEquals("Take a rest, you don't have to do anything", space.landOn());
    }

    @Test
    public void testFreeParkingSpaceLandOnIncorrectActions() {
        FreeParkingSpace space = new FreeParkingSpace();

        assertNotEquals("Property Name: Electric Company\n" +
                "Color Set: None (Utility)\n" +
                "Purchase Price: $150\n" +
                "Rent (without houses/hotels): Depends on dice roll\n" +
                "If you own 1 Utility: Rent is 4 times the amount rolled on the dice.\n" +
                "If you own 2 Utilities: Rent is 10 times the amount rolled on the dice.\n" +
                "Mortgage Value: $75\n" +
                "Houses: Cannot build houses or hotels\n" +
                "Hotel: Cannot build hotels", space.landOn());
    }

    @Test
    public void testElectricCompanySpaceLandOnCorrectActions() {
        ElectricCompanySpace space = new ElectricCompanySpace();

        assertEquals("Property Name: Electric Company\n" +
                "Color Set: None (Utility)\n" +
                "Purchase Price: $150\n" +
                "Rent (without houses/hotels): Depends on dice roll\n" +
                "If you own 1 Utility: Rent is 4 times the amount rolled on the dice.\n" +
                "If you own 2 Utilities: Rent is 10 times the amount rolled on the dice.\n" +
                "Mortgage Value: $75\n" +
                "Houses: Cannot build houses or hotels\n" +
                "Hotel: Cannot build hotels", space.landOn());
    }

    @Test
    public void testElectricCompanySpaceLandOnIncorrectActions() {
        ElectricCompanySpace space = new ElectricCompanySpace();

        assertNotEquals("Property Name: Water Works\n" +
                "Color Set: None (Utility)\n" +
                "Purchase Price: $150\n" +
                "Rent (without houses/hotels): Depends on dice roll\n" +
                "If you own 1 Utility: Rent is 4 times the amount rolled on the dice.\n" +
                "If you own 2 Utilities: Rent is 10 times the amount rolled on the dice.\n" +
                "Mortgage Value: $75\n" +
                "Houses: Cannot build houses or hotels\n" +
                "Hotel: Cannot build hotels", space.landOn());
    }

    @Test
    public void testWaterWorksSpaceLandOnCorrectActions() {
        WaterWorksSpace space = new WaterWorksSpace();

        assertEquals("Property Name: Water Works\n" +
                "Color Set: None (Utility)\n" +
                "Purchase Price: $150\n" +
                "Rent (without houses/hotels): Depends on dice roll\n" +
                "If you own 1 Utility: Rent is 4 times the amount rolled on the dice.\n" +
                "If you own 2 Utilities: Rent is 10 times the amount rolled on the dice.\n" +
                "Mortgage Value: $75\n" +
                "Houses: Cannot build houses or hotels\n" +
                "Hotel: Cannot build hotels", space.landOn());
    }

    @Test
    public void testWaterWorksSpaceLandOnIncorrectActions() {
        WaterWorksSpace space = new WaterWorksSpace();

        assertNotEquals("Pay $100", space.landOn());
    }

    @Test
    public void testLuxuryTaxSpaceLandOnCorrectActions() {
        LuxuryTaxSpace space = new LuxuryTaxSpace();

        assertEquals("Pay $100", space.landOn());
    }

    @Test
    public void testLuxuryTaxSpaceLandOnIncorrectActions() {
        LuxuryTaxSpace space = new LuxuryTaxSpace();

        assertNotEquals("Pay $200", space.landOn());
    }

    @Test
    public void testIncomeTaxSpaceLandOnCorrectActions() {
        IncomeTaxSpace space = new IncomeTaxSpace();

        assertEquals("Pay $200", space.landOn());
    }

    @Test
    public void testIncomeTaxSpaceLandOnIncorrectActions() {
        IncomeTaxSpace space = new IncomeTaxSpace();

        assertNotEquals("Go directly to Jail", space.landOn());
    }

    @Test
    public void testGoToJailSpaceLandOnCorrectActions() {
        GoToJailSpace space = new GoToJailSpace();

        assertEquals("Go directly to Jail", space.landOn());
    }

    @Test
    public void testGoToJailSpaceLandOnIncorrectActions() {
        GoToJailSpace space = new GoToJailSpace();

        assertNotEquals("Collect $200", space.landOn());
    }
}
