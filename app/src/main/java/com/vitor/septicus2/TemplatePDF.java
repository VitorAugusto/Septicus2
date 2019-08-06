package com.vitor.septicus2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TemplatePDF {

    private Context context;
    private File pdfFile;
    private Document document;
    private PdfWriter pdfWriter;


    public TemplatePDF(Context context){

        this.context = context;

    }

    public void openDocument(){
        createFile();

        try{
            document = new Document(PageSize.A4);
            pdfWriter = PdfWriter.getInstance(document,new FileOutputStream(pdfFile));
            document.open();



        }catch (Exception e){
            Log.e("openDocument", e.toString());
        }
    }


    private void createFile(){ //CRIAR ARQUIVO PDF

        File folder = new File(Environment.getExternalStorageDirectory().toString(),"TemplatesPDF_Test");

        if(!folder.exists()){
            folder.mkdirs();
        }
        pdfFile = new File(folder, "TemplatePDF.pdf");
    }

    public void closeDocument(){

        document.close();
    }


    public void fazerCoisas(){

        openDocument();
        document.setPageSize(PageSize.A4);
        document.addCreationDate();
        document.addAuthor("ANDROID STUDIO");
        document.addCreator("VITOR AUGUSTO");

        BaseColor mColorAccent = new BaseColor(0, 153, 204, 255);
        float mHeadingFontSize = 20.0f;
        float mValueFontSize = 26.0f;


        BaseFont urName = null;
        try{
            urName = BaseFont.createFont("assets/fonts/brandon_medium.otf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        }catch (Exception e){
            Log.e("nada",e.toString());
        }
        LineSeparator lineSeparator = new LineSeparator();
        lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));

        //DEFINIÇÃO DE FONTES MAIN
        Font fonteMAINTITULOHEADER = new Font(urName, 36.0f, Font.NORMAL, BaseColor.BLACK);
        Font fonteMAINCAMPO = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
        Font fonteMAINVALOR = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
        //DEFINIÇÃO DE FONTES MAIN

/*        LineSeparator lineSeparator = new LineSeparator();
        lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));

        Font mOrderDetailsTitleFont = new Font(urName,  36.0f, Font.NORMAL,  BaseColor.BLACK);

        // Creating Chunk
        Chunk mOrderDetailsTitleChunk = new Chunk("Especificações do Projeto", mOrderDetailsTitleFont);
// Creating Paragraph to add...
        Paragraph mOrderDetailsTitleParagraph = new Paragraph(mOrderDetailsTitleChunk);
// Setting Alignment for Heading
        mOrderDetailsTitleParagraph.setAlignment(Element.ALIGN_CENTER);
// Finally Adding that Chunk

      *//*  try{
            document.add(mOrderDetailsTitleParagraph);
        }catch (Exception e){

        }*//*

        //ESCOLHENDO A FONTE DA ORDEM ID - ITEMS
        Font mOrderIdFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
        //CHUNK = É O CONTEÚDO EM SI.
        Chunk mOrderIdChunk = new Chunk("Tipo Residencial:", mOrderIdFont);
        //O CHUNK É INSERIDO DENTRO DE UM PARAGRÁGO <P> </P> PARA PULAR A LINHA
        Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);

        Chunk mOrderIdChunk2 = new Chunk("Padrão Residencial:", mOrderIdFont);
        Paragraph mOrderIdParagraph2 = new Paragraph(mOrderIdChunk2);


        try{
            document.add(mOrderDetailsTitleParagraph);
            document.add(new Chunk(lineSeparator)); //SEPARADOR DE LINHA !! SUPER IMPORTANTE
            document.add(mOrderIdParagraph);
            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator)); //SEPARADOR DE LINHA !! SUPER IMPORTANTE
            document.add(new Paragraph(""));
            document.add(mOrderIdChunk2);
            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator)); //SEPARADOR DE LINHA !! SUPER IMPORTANTE
            document.add(new Paragraph(""));
        }catch (Exception e){

        }

        closeDocument();*/

        gerarImagemSepticus();

        //TÍTULO 1 - ESPECIFICAÇÕES DO PROJETO
        Font mOrderDetailsTitleFont = new Font(urName, 36.0f, Font.NORMAL, BaseColor.BLACK);
        Chunk mOrderDetailsTitleChunk = new Chunk("Especificações do Projeto", mOrderDetailsTitleFont);
        Paragraph mOrderDetailsTitleParagraph = new Paragraph(mOrderDetailsTitleChunk);
        mOrderDetailsTitleParagraph.setAlignment(Element.ALIGN_CENTER);
        try{
            document.add(mOrderDetailsTitleParagraph);
        }catch (Exception e){

        }

        //ITEM 1 - NUM. DE PESSOAS
        Font mOrderIdFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
        Chunk mOrderIdChunk = new Chunk("Número de pessoas:", mOrderIdFont);
        Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
        try{
            document.add(mOrderIdParagraph);
        }catch (Exception e){

        }

        //VALOR ITEM 1
        Font mOrderIdValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
        Chunk mOrderIdValueChunk = new Chunk("4", mOrderIdValueFont); //VALOR NÚMERO DE PESSOAS
        Paragraph mOrderIdValueParagraph = new Paragraph(mOrderIdValueChunk);
        try{
            document.add(mOrderIdValueParagraph);
        }catch (Exception e){

        }

        // LINHAS DE SEPARAÇÃO ENTRE DIFERENTES ITEMS
        try {
            document.add(new Paragraph(""));
            // Adding Horizontal Line...
            document.add(new Chunk(lineSeparator));
            // Adding Line Breakable Space....
            document.add(new Paragraph(""));
        }catch (Exception e){

        }

        //ITEM 2 - PADRÃO DA RESIDÊNCIA
        Font mOrderDateFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
        Chunk mOrderDateChunk = new Chunk("Padrão residencial:", mOrderDateFont);
        Paragraph mOrderDateParagraph = new Paragraph(mOrderDateChunk);
        try {
            document.add(mOrderDateParagraph);
        }catch (Exception e){

        }

        //VALOR ITEM 2
        Font mOrderDateValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
        Chunk mOrderDateValueChunk = new Chunk("Padrão médio", mOrderDateValueFont);
        Paragraph mOrderDateValueParagraph = new Paragraph(mOrderDateValueChunk);
        try {
            document.add(mOrderDateValueParagraph);
        }catch (Exception e){

        }

        // LINHAS DE SEPARAÇÃO ENTRE DIFERENTES ITEMS
        try {
            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));
        }catch (Exception e){

        }

        //CAMPO 3 - TIPO DE RESIDÊNCIA
        Font mOrderAcNameFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
        Chunk mOrderAcNameChunk = new Chunk("Tipo de residência:", mOrderAcNameFont);
        Paragraph mOrderAcNameParagraph = new Paragraph(mOrderAcNameChunk);
        try{
            document.add(mOrderAcNameParagraph);
        }catch (Exception e){

        }

        //VALOR ITEM 3
        Font mOrderAcNameValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
        Chunk mOrderAcNameValueChunk = new Chunk("Residência", mOrderAcNameValueFont);
        Paragraph mOrderAcNameValueParagraph = new Paragraph(mOrderAcNameValueChunk);
        try{
            document.add(mOrderAcNameValueParagraph);
        }catch (Exception e){

        }

        // LINHAS DE SEPARAÇÃO ENTRE DIFERENTES ITEMS
        try {
            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));
        }catch (Exception e){

        }


        //CAMPO 4 - TEMPERATURA MÉDIA MÊS MAIS FRIO
        Chunk chunkTempMedia = new Chunk("Temperatura média no mês mais frio:", fonteMAINCAMPO);
        Paragraph paragraphTempMedia = new Paragraph(chunkTempMedia);

        try{
            document.add(paragraphTempMedia);
        }catch (Exception e){

        }

        //VALOR ITEM 4
        Chunk chunkTempMediaValor = new Chunk("Entre 10 ºC à 20 ºC", fonteMAINVALOR);
        Paragraph paragraphTempMediaValor = new Paragraph(chunkTempMediaValor);

        try{
            document.add(paragraphTempMediaValor);
        }catch (Exception e){

        }

        // LINHAS DE SEPARAÇÃO ENTRE DIFERENTES ITEMS
        try {
            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));
        }catch (Exception e){

        }

        //CAMPO 5 - INTERVALO ENTRE LIMPEZAS
        Chunk chunkIntervaloLimpeza = new Chunk("Intervalo entre limpezas(anos):", fonteMAINCAMPO);
        Paragraph paragraphIntervaloLimpeza = new Paragraph(chunkIntervaloLimpeza);

        try{
            document.add(paragraphIntervaloLimpeza);
        }catch (Exception e){

        }

        //VALOR ITEM 5
        Chunk chunkIntervaloLimpezaValor = new Chunk("04 anos", fonteMAINVALOR);
        Paragraph paragraphIntervaloLimpezaValor = new Paragraph(chunkIntervaloLimpezaValor);

        try{
            document.add(paragraphIntervaloLimpezaValor);

        }catch (Exception e){

        }

        // LINHAS DE SEPARAÇÃO ENTRE DIFERENTES ITEMS
        try {
            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));
        }catch (Exception e){

        }

        //CAMPO 6 - CONTRIBUIÇÃO DE DESPEJOS
        Chunk chunkContribuicaoDespejos = new Chunk("Contribuição total de despejos:", fonteMAINCAMPO);
        Paragraph paragraphContribuicaoDespejos = new Paragraph(chunkContribuicaoDespejos);


        try{
            document.add(paragraphContribuicaoDespejos);

        }catch (Exception e){

        }

        //VALOR ITEM 6
        Chunk chunkContribuicaoDespejosValor = new Chunk("10 L/dia", fonteMAINVALOR);
        Paragraph paragraphContribuicaoDespejosValor = new Paragraph(chunkContribuicaoDespejosValor);

        try{
            document.add(paragraphContribuicaoDespejosValor);
        }catch (Exception e){

        }

        // LINHAS DE SEPARAÇÃO ENTRE DIFERENTES ITEMS
        try {
            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));
        }catch (Exception e){

        }

        //CAMPO 7 - CONTRIBUIÇÃO TOTAL IODO
        Chunk chunkContribuicaoTotalIodo = new Chunk("Contribuição total de Iodo:", fonteMAINCAMPO);
        Paragraph paragraphContribuicaoTotalIodo = new Paragraph(chunkContribuicaoTotalIodo);

        try{
            document.add(paragraphContribuicaoTotalIodo);
        }catch (Exception e){

        }

        //VALOR ITEM 7
        Chunk chunkContribuicaoTotalIodoValor = new Chunk("1 L/dia", fonteMAINVALOR);
        Paragraph paragraphContribuicaoTotalIodoValor = new Paragraph(chunkContribuicaoTotalIodoValor);

        try{
            document.add(paragraphContribuicaoTotalIodoValor);
        }catch (Exception e){

        }

        // LINHAS DE SEPARAÇÃO ENTRE DIFERENTES ITEMS
        try {
            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));
        }catch (Exception e){

        }

        //TÍTULO 2 - ESPECIFICAÇÕES DO PROJETO

        gerarTitutlo2Cilindrico(fonteMAINTITULOHEADER);








        document.close();


    }

    private void gerarTitutlo2Cilindrico(Font fontMAIN){

        Chunk chunkTitulo2 = new Chunk("Tanque Séptico Cilíndrico", fontMAIN);
        Paragraph paragraphTitulo2 = new Paragraph(chunkTitulo2);
        paragraphTitulo2.setAlignment(Element.ALIGN_CENTER);
        try{
            document.add(paragraphTitulo2);
        }catch (Exception e){

        }

    }

    private void gerarTitulo2Retangular(Font fontMAIN){

        Chunk chunkTitulo2 = new Chunk("Tanque Séptico Retangular", fontMAIN);
        Paragraph paragraphTitulo2 = new Paragraph(chunkTitulo2);
        paragraphTitulo2.setAlignment(Element.ALIGN_CENTER);
        try{
            document.add(paragraphTitulo2);
        }catch (Exception e){

        }

    }

    private void gerarImagemSepticus(){

        try {

            InputStream ims = context.getAssets().open("septicus_logo_pdf1.jpeg");
            Bitmap bmp = BitmapFactory.decodeStream(ims);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            Image image = null;
            try{
                image = Image.getInstance(stream.toByteArray());
                image.scaleToFit(400,200);
                image.setAlignment(Element.ALIGN_CENTER);
            }catch (Exception e){
                Log.e("erro", e.toString());
            }

            try{
                document.add(image);
            }catch (Exception e){

            }
        }
        catch(IOException ex)
        {
            return;
        }

    }
}
