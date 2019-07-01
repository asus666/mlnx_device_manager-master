package com.mlnx.device_manager.web.controller;

import com.mlnx.device_manager.entity.Contract;
import com.mlnx.device_manager.entity.DeviceMalfunction;
import com.mlnx.device_manager.mappers.*;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class ExcelController {

        @Autowired
        private TDeviceMalfunctionMapper tDeviceMalfunctionMapper;

        @Autowired
        private TDeviceMapper tDeviceMapper;

        @Autowired
        private TContractMapper tContractMapper;

        @Autowired
        private TDealerMapper tDealerMapper;

        @Autowired
        private TUserMapper tUserMapper;


        @ApiOperation(value = "导出故障信息",notes = "")
        @GetMapping("/getMalfunctionExcel")
        public void getMalfunctionExcel (HttpServletResponse response) throws Exception {
            List<DeviceMalfunction>userList =tDeviceMalfunctionMapper.selectList(null);

            HSSFWorkbook wb = new HSSFWorkbook();
            //工作表名
            HSSFSheet sheet =wb.createSheet("获取excel测试表格");
            HSSFRow row = null;

            row = sheet.createRow(0);
            row.setHeight((short)(26.25*20));
            row.createCell(0).setCellValue("故障信息表");
            row.getCell(0).setCellStyle(getStyle1(wb,0));//设置样式
            for(int i = 1;i <= 4;i++){
                row.createCell(i).setCellStyle(getStyle1(wb,0));
            }
            CellRangeAddress rowRegion = new CellRangeAddress(0,0,0,4);
            sheet.addMergedRegion(rowRegion);

            //CellRangeAddress columnRegion = new CellRangeAddress(1, userList.size()+1,0,0);
            //sheet.addMergedRegion(columnRegion);

            row = sheet.createRow(1);
            //row.createCell(0).setCellStyle(getStyle1(wb,3));
            row.setHeight((short)(22.50*20));
            //row.createCell(1).setCellValue("序号id");
            row.createCell(0).setCellValue("设备编号");
            row.createCell(1).setCellValue("返厂原因");
            row.createCell(2).setCellValue("返厂时间");
            row.createCell(3).setCellValue("备注");
            row.createCell(4).setCellValue("处理结果");
            for(int i = 0;i <= 4;i++){
                row.getCell(i).setCellStyle(getStyle1(wb,1));
            }

            for(int i = 0;i<userList.size();i++){
                row = sheet.createRow(i+2);
                DeviceMalfunction user = userList.get(i);
                //row.createCell(1).setCellValue(user.getId());
                String num=tDeviceMapper.selectById(user.getDeviceId()).getNumeration();
                row.createCell(0).setCellValue(num);
                row.createCell(1).setCellValue(user.getMalfunction());
                if(user.getBackDate()==null){
                    row.createCell(2).setCellValue("");
                }else {
                    row.createCell(2).setCellValue(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(user.getBackDate()));
                }
                row.createCell(3).setCellValue(user.getState());
                if(user.getRemark()==null){
                    row.createCell(4).setCellValue("");
                }else{
                    row.createCell(4).setCellValue(user.getRemark());
                }
                for(int j = 0;j <= 4;j++){
                    row.getCell(j).setCellStyle(getStyle1(wb,2));
                }
            }

            //默认行高
            sheet.setDefaultRowHeight((short)(16.5*20));
            //列宽自适应
            for(int i=0;i<=13;i++){
                sheet.autoSizeColumn(i);
            }

            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            //设置文件名
            String filename = "设备故障表";
            //设置响应的编码
            response.setContentType("application/x-download");//下面三行是关键代码，处理乱码问题
            response.setCharacterEncoding("utf-8");
            //设置浏览器响应头对应的Content-disposition
            response.setHeader("Content-disposition", "attachment;filename="+new String(filename.getBytes("gbk"), "iso8859-1")+".xls");
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        }

        /**
         * 获取样式
         * @param hssfWorkbook
         * @param styleNum
         * @return
         */
        public HSSFCellStyle getStyle1(HSSFWorkbook hssfWorkbook, Integer styleNum){
            HSSFCellStyle style = hssfWorkbook.createCellStyle();
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框

            HSSFFont font = hssfWorkbook.createFont();
            font.setFontName("微软雅黑");//设置字体为微软雅黑

            HSSFPalette palette = hssfWorkbook.getCustomPalette();//拿到palette颜色板,可以根据需要设置颜色
            switch (styleNum){
                case(0):{
                    style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//跨列居中
                    font.setBold(true);//粗体
                    font.setFontHeightInPoints((short) 14);//字体大小
                    style.setFont(font);
                    palette.setColorAtIndex(HSSFColor.BLUE.index,(byte)184,(byte)204,(byte)228);//替换颜色板中的颜色
                    style.setFillForegroundColor(HSSFColor.BLUE.index);
                    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                }
                break;
                case(1):{
                    font.setBold(true);//粗体
                    font.setFontHeightInPoints((short) 11);//字体大小
                    style.setFont(font);
                }
                break;
                case(2):{
                    font.setFontHeightInPoints((short)10);
                    style.setFont(font);
                }
                break;
                case(3):{
                    style.setFont(font);
                    palette.setColorAtIndex(HSSFColor.GREEN.index,(byte)0,(byte)32,(byte)96);//替换颜色板中的颜色
                    style.setFillForegroundColor(HSSFColor.GREEN.index);
                    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                }
                break;
            }
            return style;
        }













    @ApiOperation(value = "导出合同信息",notes = "")
    @GetMapping("/getContractExcel")
    public void getContractExcel (HttpServletResponse response) throws Exception {
        List<Contract> userList = tContractMapper.selectList(null);

        HSSFWorkbook wb = new HSSFWorkbook();
        //工作表名
        HSSFSheet sheet = wb.createSheet("获取excel测试表格");
        HSSFRow row = null;

        row = sheet.createRow(0);
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("合同信息表");
        row.getCell(0).setCellStyle(getStyle(wb, 0));//设置样式
        for (int i = 1; i <= 5; i++) {
            row.createCell(i).setCellStyle(getStyle(wb, 0));
        }
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 5);
        sheet.addMergedRegion(rowRegion);

        //CellRangeAddress columnRegion = new CellRangeAddress(1, userList.size()+1,0,0);
        //sheet.addMergedRegion(columnRegion);

        row = sheet.createRow(1);
        //row.createCell(0).setCellStyle(getStyle(wb,3));
        row.setHeight((short) (22.50 * 20));
        //row.createCell(0).setCellValue("序号id");
        row.createCell(0).setCellValue("合同编号");
        row.createCell(1).setCellValue("经销商");
        row.createCell(2).setCellValue("医院");
        row.createCell(3).setCellValue("发货时间");
        row.createCell(4).setCellValue("签订人");
        row.createCell(5).setCellValue("备注");
        //row.createCell(6).setCellValue("相关设备");
        for (int i = 0; i <= 5; i++) {
            row.getCell(i).setCellStyle(getStyle(wb, 1));
        }

        for (int i = 0; i < userList.size(); i++) {
            row = sheet.createRow(i + 2);
            Contract user = userList.get(i);
            //row.createCell(0).setCellValue(user.getId());
            row.createCell(0).setCellValue(user.getNumeration());
            if (user.getDealerId() == 0) {
                row.createCell(1).setCellValue(" ");
            } else {
                row.createCell(1).setCellValue(tDealerMapper.selectById(user.getDealerId()).getDealerName());
            }

            if (user.getHospitalId() == 0) {
                row.createCell(2).setCellValue(" ");
            } else {
                row.createCell(2).setCellValue(tUserMapper.selectById(user.getHospitalId()).getHospitalName());
            }
            row.createCell(3).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(user.getDeliverDate()));
            row.createCell(4).setCellValue(user.getSigner());
            row.createCell(5).setCellValue(user.getRemark());
            //List<Device>devices=tDeviceMapper.selectList(new QueryWrapper<Device>().eq("contract_id",user.getId()));
            //Iterator<Device> it=devices.iterator();
            //List list=new ArrayList();
            //while(it.hasNext()){
            //    Device d=it.next();
            //    list.add(d.getNumeration());
            //}
            //row.createCell(6).setCellValue(list.toString());
            for (int j = 0; j <= 5; j++) {
                row.getCell(j).setCellStyle(getStyle(wb, 2));
            }
        }
        row = sheet.createRow(3 + userList.size());
        row.setHeight((short) (22.50 * 20));
        row.createCell(0).setCellValue("相关设备");
        row = sheet.createRow(4 + userList.size());
        for (int i = 0; i < userList.size(); i++) {
            Contract user = userList.get(i);
            row.createCell(i).setCellValue(user.getNumeration());
        }

        for (int i = 0; i < userList.size(); i++) {
            row.getCell(i).setCellStyle(getStyle(wb, 1));
        }

        //1.合同有几条就循环几次 分别取到每条数据
        //2.根据每个合同号找出对应的设备有几个
        //3.根据设备数量建行建单元格
        //有几个设备就有几行数据
        //循环建行，后一个合同的第一个设备编号为前一行的第二个单元格

        for (int i = 0; i < userList.size(); i++) {
            Contract user = userList.get(i);
            List<Contract> list = tContractMapper.selectDN(user.getId());
            for (int j = 0; j < list.size(); j++) {
                //if(sheet.getPhysicalNumberOfRows()>=(5+userList.size()+j)){
                //    row.createCell(j).setCellValue(user.getNumeration());
                //    row.getCell(j).setCellStyle(getStyle(wb,2));
                //}
                //i==1时，不用再创建一行，只要得到这一行，并在第二个单元格填数据
                //if (sheet.getPhysicalNumberOfRows() < 5 + userList.size() + j) {
                //if(j<1) {
                if(sheet.getRow(5 + userList.size()+j)==null){
                    row = sheet.createRow(5 + userList.size()+j);
                    row.createCell(i).setCellValue(list.get(j).getNumeration());
                    row.getCell(i).setCellStyle(getStyle(wb, 2));
                }else{
                    row =sheet.getRow(5 + userList.size()+j);
                    row.createCell(i).setCellValue(list.get(j).getNumeration());
                    row.getCell(i).setCellStyle(getStyle(wb, 2));
                }
            }
        }

        //默认行高
        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }

        HSSFPrintSetup ps = sheet.getPrintSetup();
        ps.setLandscape(true); // 打印方向，true：横向，false：纵向(默认)


        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //设置文件名
        String filename = "合同信息表";
        //设置响应的编码
        response.setContentType("application/x-download");//下面三行是关键代码，处理乱码问题
        response.setCharacterEncoding("utf-8");
        //设置浏览器响应头对应的Content-disposition
        response.setHeader("Content-disposition", "attachment;filename=" + new String(filename.getBytes("gbk"), "iso8859-1") + ".xls");
        OutputStream os = response.getOutputStream();
        wb.write(os);
        os.flush();
        os.close();

    }

    /**
     * 获取样式
     * @param hssfWorkbook
     * @param styleNum
     * @return
     */
    public HSSFCellStyle getStyle(HSSFWorkbook hssfWorkbook, Integer styleNum){
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框

        HSSFFont font = hssfWorkbook.createFont();
        font.setFontName("微软雅黑");//设置字体为微软雅黑

        HSSFPalette palette = hssfWorkbook.getCustomPalette();//拿到palette颜色板,可以根据需要设置颜色
        switch (styleNum){
            case(0):{
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//跨列居中
                font.setBold(true);//粗体
                font.setFontHeightInPoints((short) 14);//字体大小
                style.setFont(font);
                palette.setColorAtIndex(HSSFColor.BLUE.index,(byte)184,(byte)204,(byte)228);//替换颜色板中的颜色
                style.setFillForegroundColor(HSSFColor.BLUE.index);
                style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            }
            break;
            case(1):{
                font.setBold(true);//粗体
                font.setFontHeightInPoints((short) 11);//字体大小
                style.setFont(font);
            }
            break;
            case(2):{
                font.setFontHeightInPoints((short)10);
                style.setFont(font);
            }
            break;
            case(3):{
                style.setFont(font);
                palette.setColorAtIndex(HSSFColor.GREEN.index,(byte)0,(byte)32,(byte)96);//替换颜色板中的颜色
                style.setFillForegroundColor(HSSFColor.GREEN.index);
                style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            }
            break;
        }
        return style;
    }
    }


