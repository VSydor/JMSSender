package com.vs.jmssender.repository;

public class PayloadRepository {

    public static String orchestratorPayload1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<orchestratorDocumentsCreationResult>\n" +
            "    <expeditionTypeId>3</expeditionTypeId>\n" +
            "    <expeditionId>1603</expeditionId>\n" +
            "    <resultCode>OK</resultCode>\n" +
            "    <expeditionContent>\n" +
            "        <expeditionFile>\n" +
            "            <invoiceId>39231102</invoiceId>\n" +
            "            <documentFileName>289132978_Z98-38258_21092020_CUSTOMS_MASTER.csv</documentFileName>\n" +
            "        </expeditionFile>\n" +
            "    </expeditionContent>\n" +
            "</orchestratorDocumentsCreationResult>";

    public static String orchestratorPayload2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<orchestratorDocumentsCreationResult>\n" +
            "    <expeditionTypeId>3</expeditionTypeId>\n" +
            "    <expeditionId>12345</expeditionId>\n" +
            "    <resultCode>OK</resultCode>\n" +
            "    <expeditionContent>\n" +
            "        <expeditionFile>\n" +
            "            <invoiceId>37648533</invoiceId>\n" +
            "            <documentFileName>289132978_Z98-38258_21092020_CUSTOMS_MASTER.csv</documentFileName>\n" +
            "        </expeditionFile>\n" +
            "<expeditionFile>\n" +
            "            <invoiceId>9999999</invoiceId>\n" +
            "            <documentFileName>289132978_Z98-38258_21092020_CUSTOMS_MASTER.csv</documentFileName>\n" +
            "        </expeditionFile>" +
            "    </expeditionContent>\n" +
            "</orchestratorDocumentsCreationResult>";

    public static String orchestratorPayload3 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<orchestratorDocumentsCreationResult>\n" +
            "    <expeditionTypeId>3</expeditionTypeId>\n" +
            "    <expeditionId>16031</expeditionId>\n" +
            "    <resultCode>OK</resultCode>\n" +
            "    <expeditionContent>\n" +
            "        <expeditionFile>\n" +
            "            <invoiceId>37648533</invoiceId>\n" +
            "            <documentFileName>289132978_Z98-38258_21092020_CUSTOMS_MASTER.csv</documentFileName>\n" +
            "        </expeditionFile>\n" +
            "    </expeditionContent>\n" +
            "</orchestratorDocumentsCreationResult>";

    // assign?
    String packageAssignmentPayload = "{\n" +
            "\t\"type\": \"PalletToOperation\",\n" +
            "\t\"idSistemaGenerador\": 0,\n" +
            "\t\"header\": {\n" +
            "\t\t\"generationDate\": \"2021-03-15T19:03:10.789Z\",\n" +
            "\t\t\"operationDate\": \"2021-03-15T19:03:03.000Z\",\n" +
            "\t\t\"messageId\": \"20210315190310789_21545\",\n" +
            "\t\t\"version\": \"1.0\",\n" +
            "\t\t\"messageType\": \"PACKAGES_ASSIGNMENT_TO_TRANSPORT\"\n" +
            "\t},\n" +
            "\t\"scanInformation\": {\n" +
            "\t\t\"operationType\": \"A\",\n" +
            "\t\t\"groupType\": \"L\",\n" +
            "\t\t\"retroPhysicalGroupId\": 7600564,\n" +
            "\t\t\"stopId\": 1147860,\n" +
            "\t\t\"transportLocationId\": 10003,\n" +
            "\t\t\"scanDate\": \"2021-03-15T19:03:03.000Z\",\n" +
            "\t\t\"scanLocation\": 0,\n" +
            "\t\t\"palletCode\": \"000700000823993\",\n" +
            "\t\t\"palletType\": \"7\"\n" +
            "\t},\n" +
            "\t\"packages\": [{\n" +
            "\t\t\"packageId\": 105072916,\n" +
            "\t\t\"packageDate\": \"2021-03-15T00:00:00.000Z\",\n" +
            "\t\t\"barcode\": \"30100030055125032021\",\n" +
            "\t\t\"barcodeVersion\": \"3\",\n" +
            "\t\t\"originLocationId\": 10003,\n" +
            "\t\t\"destinationLocationId\": 5515,\n" +
            "\t\t\"weight\": 7.68,\n" +
            "\t\t\"volume\": 0.079,\n" +
            "\t\t\"length\": 0.47,\n" +
            "\t\t\"width\": 0.29,\n" +
            "\t\t\"height\": 0.58,\n" +
            "\t\t\"originCreationDate\": \"2021-03-15T02:34:27.000Z\",\n" +
            "\t\t\"modificationDate\": \"2021-03-15T19:03:03.000Z\",\n" +
            "\t\t\"folderGarment\": true,\n" +
            "\t\t\"section\": 1,\n" +
            "\t\t\"aparte\": 0,\n" +
            "\t\t\"brand\": 2,\n" +
            "\t\t\"shoppingCenterId\": 2,\n" +
            "\t\t\"productId\": 2\n" +
            "\t}]\n" +
            "}";

}
