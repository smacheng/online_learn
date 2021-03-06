package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class GeneSql {
	
	private static EntityResolver resolver = 
//		new EntityResolver() {
//	    public InputSource resolveEntity(String publicId, String systemId) {
//	        if ( publicId.equals( "-//ibatis.apache.org//DTD SQL Map 2.0//EN" ) ) {
//	            InputStream in = this.getClass().getResourceAsStream("/sql-map-2.dtd");
//	            return new InputSource( in );
//	        }
//	        return null;
//	    }
//	};
		new EntityResolver() {
        public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
            InputStream dtdin=null;
            // dtdin = this.getClass().getResourceAsStream("struts-config_1_1.dtd");
            dtdin=new FileInputStream(new File(GeneUtil.FilePath_Real+"/codeGen/changeCodeGen/lib/sql-map-2.dtd"));
            return new InputSource(dtdin);
        }
	};
    
    
	// 从一个sql文件解析column字段信息，并且初始化包名表明等,并且初始化pk的值和pkValue的值
	public boolean geneColumns(File inputXml,SqlTemplateVO vo){
		if(!inputXml.exists())
			return false;
		SAXReader saxReader = new SAXReader();
		saxReader.setEntityResolver( resolver );
		Document document;
		try {
			document = saxReader.read(inputXml);
			// 初始化pk和pkValue
			List list_select = document.selectNodes("//sqlMap/select" );
			if(list_select!=null&&list_select.size()>0){
			   String id_select = "";
			   String pkAndValue;
               Iterator ite_select = list_select.iterator();
			   while(ite_select.hasNext()){
				   Element element_select = (Element)ite_select.next();
				   id_select = element_select.attribute("id").getValue();
			       if(id_select!=null&&id_select.trim().indexOf("selectByPrimaryKey")!=-1){
			    	   int index = element_select.getText().lastIndexOf("where");
			    	   if(index!=-1){
			    		   pkAndValue = element_select.getText().substring(index+6).trim();
			    		   vo.setPk(pkAndValue.substring(0, pkAndValue.indexOf("=")).trim());
			    		   vo.setPkValue(pkAndValue.substring(pkAndValue.indexOf("=")+1).trim());
			    	   }	   
			       }
				}
				
			}
			
			// 解析resultMap中的字段信息
			List list = document.selectNodes("//sqlMap/resultMap" );
			System.out.println("list尺寸："+list.size());
			Iterator iter=list.iterator();
			
			while(iter.hasNext()){
				String property = "";
				String jdbcType = "";
				String column = "";
				
				Element element=(Element)iter.next();
	            Iterator ite_result = element.elementIterator();
//System.out.println("在geneColumns中的文件名："+inputXml.getName());
	            while(ite_result.hasNext()){
	         	   Element element_result = (Element)ite_result.next();
	            
				   property = element_result.attribute("property").getValue(); 
				   jdbcType = element_result.attribute("jdbcType").getValue();
				   column = element_result.attribute("column").getValue();
		   // 设置pkProperty
				   if(column!=null&&column.trim().equals(vo.getPk()))
					   vo.setPkProperty(property);

				   ColumnVO columnVO = new ColumnVO(column, property, jdbcType);
				   vo.getColumnVO_all().add(columnVO);
				   if(jdbcType!=null&&jdbcType.trim().equals(GeneUtil.BlobType))
					   vo.getColumnVO_Blobs().add(columnVO);
				   else 
					   vo.getColumnVO_withoutBlobs().add(columnVO);
	            }
			}

		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
        if((vo.getColumnVO_all().size()<=0))
        	return false;
        else 
        	return true;
	}
	
	/**
	 * 根据sql_Map文件判断，该文件里是否有blob类型字段
	 * @param file
	 * @return
	 */
	public static boolean hasBlobs(File file){
		if(!file.exists())
			return false;
		SAXReader saxReader = new SAXReader();
		saxReader.setEntityResolver( resolver );
		Document document;
		boolean result = false;
		try {
			document = saxReader.read(file);
						
			// 解析resultMap中的字段信息
			List list = document.selectNodes("//sqlMap/resultMap" );
			Iterator iter=list.iterator();
			
			while(iter.hasNext()){
				String jdbcType = "";
				
				Element element=(Element)iter.next();
	            Iterator ite_result = element.elementIterator();
	            while(ite_result.hasNext()){
	         	   Element element_result = (Element)ite_result.next();
	            
				   jdbcType = element_result.attribute("jdbcType").getValue();
				   if(jdbcType!=null&&jdbcType.trim().equals(GeneUtil.BlobType)){
					   result = true;
					   return result;
				   }
	            }
			}

		} catch (DocumentException e) {
			e.printStackTrace();
		}
        return result;
	}
	
	/**
	 * 根据abator的sql文件，得到该文件对应的类的pk属性
	 * @param file
	 * @return
	 */
	public String getPK(File file){
		if(file==null||!file.exists())
			return null;
		SqlTemplateVO vo = new SqlTemplateVO();
		boolean result = geneColumns(file,vo);
		String pkProperty = vo.getPkProperty();
		if(pkProperty!=null)
			pkProperty = pkProperty.trim();
		return pkProperty;
	}
	
	// 初始化columnsList_select
	public boolean geneColumnsList_select(SqlTemplateVO vo){
		List columnVO_all = vo.getColumnVO_all();
			
		if(columnVO_all==null||columnVO_all.size()<=0){
			vo.setColumnsList_select("");
			return false;
		}
			
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<columnVO_all.size();i++){
			ColumnVO vo_temp = (ColumnVO)columnVO_all.get(i);
			if(vo_temp!=null&&vo_temp.getColumn()!=null)
			   buffer.append("    ").append(vo_temp.getColumn()).append(",\n");
		}
		vo.setColumnsList_select(buffer.substring(0, buffer.lastIndexOf(",")));
		if(vo.getColumnsList_select()==null)
			return false;
		else return true;
	}
	
	// 初始化columns_withoutBlobs_List_select
	public boolean geneColumns_withoutBlobs_List_select(SqlTemplateVO vo){
		List columnVO_withoutBlobs = vo.getColumnVO_withoutBlobs();
		
		if(columnVO_withoutBlobs==null||columnVO_withoutBlobs.size()<=0){
			vo.setColumns_withoutBlobs_List_select("");
			return false;
		}
			
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<columnVO_withoutBlobs.size();i++){
			ColumnVO vo_temp = (ColumnVO)columnVO_withoutBlobs.get(i);
			if(vo_temp!=null&&vo_temp.getColumn()!=null)
			   buffer.append("    ").append(vo_temp.getColumn()).append(",\n");
		}
		vo.setColumns_withoutBlobs_List_select(buffer.substring(0, buffer.lastIndexOf(",")));
		if(vo.getColumns_withoutBlobs_List_select()==null)
			return false;
		else return true;
	}
	
	// 初始化columnValuesList_insert
	public boolean geneColumnValuesList_insert(SqlTemplateVO vo){
		List columnVO_all = vo.getColumnVO_all();
		
		if(columnVO_all==null||columnVO_all.size()<=0){
			vo.setColumnValuesList_insert("");
			return false;	
		}

		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<columnVO_all.size();i++){
			ColumnVO vo_temp = (ColumnVO)columnVO_all.get(i);
			if(vo_temp!=null&&vo_temp.getColumn()!=null)
			   buffer.append("    #").append(vo_temp.getProperty()).append(":").append(vo_temp.getJdbcType()).append("#, \n");
		}
		vo.setColumnValuesList_insert(buffer.substring(0, buffer.lastIndexOf(",")));
		if(vo.getColumnValuesList_insert()==null)
			return false;
		else return true;
	}
	
	// 初始化results
	public boolean geneResults(SqlTemplateVO vo){
		List columnVOs = vo.getColumnVO_all();
		
		if(columnVOs==null||columnVOs.size()<=0){
			vo.setResults("");
			return true;
		}
			
	    StringBuffer rtn = new StringBuffer();
		for(int i=0;i<columnVOs.size();i++){
	    	ColumnVO vo_temp = (ColumnVO)columnVOs.get(i);
	    	rtn.append("    <result column=\"").append(vo_temp.getColumn()).append("\" property=\"")
	    	   .append(vo_temp.getProperty()).append("\" ").append("jdbcType=\"").append(vo_temp.getJdbcType())
	    	   .append("\"/>\n");
	    }
		vo.setResults(rtn.toString());
		return true;
	}
	
	// 初始化result_withoutBlobs
	public boolean geneResult_withoutBlobs(SqlTemplateVO vo){
		List columnVO_withoutBlobs = vo.getColumnVO_withoutBlobs();
		
		if(columnVO_withoutBlobs==null||columnVO_withoutBlobs.size()<=0){
			vo.setResult_withoutBlobs("");
			return true;
		}
			
	    StringBuffer rtn = new StringBuffer();
		for(int i=0;i<columnVO_withoutBlobs.size();i++){
	    	ColumnVO vo_temp = (ColumnVO)columnVO_withoutBlobs.get(i);
	    	rtn.append("    <result column=\"").append(vo_temp.getColumn()).append("\" property=\"")
	    	   .append(vo_temp.getProperty()).append("\" ").append("jdbcType=\"").append(vo_temp.getJdbcType())
	    	   .append("\"/>\n");
	    }
		vo.setResult_withoutBlobs(rtn.toString());
		return true;
	}
	
	// 初始化result_Blobs
	public boolean geneResult_Blobs(SqlTemplateVO vo){
		List columnVO_Blobs = vo.getColumnVO_Blobs();

		if(columnVO_Blobs==null||columnVO_Blobs.size()<=0){
           vo.setResult_Blobs("");
           return true;
		}

	    StringBuffer rtn = new StringBuffer();
		for(int i=0;i<columnVO_Blobs.size();i++){
	    	ColumnVO vo_temp = (ColumnVO)columnVO_Blobs.get(i);
	    	rtn.append("    <result column=\"").append(vo_temp.getColumn()).append("\" property=\"")
	    	   .append(vo_temp.getProperty()).append("\" jdbcType=\"").append(vo_temp.getJdbcType())
	    	   .append("\"/>\n");
	    }
		vo.setResult_Blobs(rtn.toString());
		return true;
	}
	
	//初始化 where_clause
	public boolean geneWhere_Clause(SqlTemplateVO vo){
		List columnVO_all = vo.getColumnVO_all();
		
		if(columnVO_all==null||columnVO_all.size()<=0){
			vo.setWhere_Clause("");
			return false;
		}
			
		String isNotEmpty = "isNotEmpty";
		String isNotNull = "isNotNull";
		String whereType = "isNotNull";
		
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<columnVO_all.size();i++){
			ColumnVO vo_temp = (ColumnVO)columnVO_all.get(i);
			if("VARCHAR".equalsIgnoreCase(vo_temp.getJdbcType().trim())||"LONGVARCHAR".equalsIgnoreCase(vo_temp.getJdbcType().trim()))
				whereType = isNotEmpty;
			else 
				whereType = isNotNull;
		    buffer.append("      <").append(whereType).append(" prepend=\"and\" property=\"")
		    .append(vo_temp.getProperty()).append("\"><![CDATA[ ")
		    .append(vo_temp.getColumn()).append("=#").append(vo_temp.getProperty())
		    .append(":").append(vo_temp.getJdbcType()).append("# ]]></")
		    .append(whereType).append(">\n");
		}
		vo.setWhere_Clause(buffer.toString());
		return true;
	}
	
	// 初始化updateSetClause
	public boolean geneUpdateSetClause(SqlTemplateVO vo){
		List columnVO_all = vo.getColumnVO_all();
		
		if(columnVO_all==null||columnVO_all.size()<=0){
			vo.setUpdateSetClause("");
			return false;
		}
			
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<columnVO_all.size();i++){
			ColumnVO vo_temp = (ColumnVO)columnVO_all.get(i);
			if(vo_temp.getColumn().trim().equals(vo.getPk()))
				continue;
		    buffer.append("      <isNotNull prepend=\",\" property=\"")
		    .append(vo_temp.getProperty()).append("\"><![CDATA[ ")
		    .append(vo_temp.getColumn()).append("=#").append(vo_temp.getProperty())
		    .append(":").append(vo_temp.getJdbcType()).append("# ]]></isNotNull>\n");
		}
		vo.setUpdateSetClause(buffer.toString());
		return true;
	}
	
	
	/**
	 * 生成以上定义的类成员值
	 * @param inputXml
	 * @return
	 */
	public boolean geneAllValues(File inputXml,SqlTemplateVO vo){
		boolean result = false;
		
		result = geneColumns(inputXml,vo);
		if(result==false)
			return false;
		vo.setClassName(GeneUtil.getClassNameFromSql(inputXml.getName()));
		vo.setTableName(GeneUtil.getTableNameFromSql(inputXml.getName()));
		result = result && this.geneColumns_withoutBlobs_List_select(vo);
        result = result && this.geneColumnsList_select(vo);
        result = result && this.geneColumnValuesList_insert(vo);
        result = result && this.geneResults(vo);
        result = result && this.geneResult_Blobs(vo);
        result = result && this.geneResult_withoutBlobs(vo);
        result = result && this.geneUpdateSetClause(vo);
        result = result && this.geneWhere_Clause(vo);
        return result;
	}
	
	/**
	 * 根据一个sql文件生成相关的列值，并生成想要的sql文件
	 * @param file
	 * @return
	 */
	public String printSqlFile(File file){
		if(!file.exists())
			return "文件不存在！";
		SqlTemplateVO vo = new SqlTemplateVO();
		
		StringBuffer errs = new StringBuffer();
		if(!geneAllValues(file,vo))
			errs.append(file.getName()+":生成列值时出错！");
		boolean hasBlobs = false;
		if(vo.getColumnVO_Blobs()!=null&&vo.getColumnVO_Blobs().size()>0)
			hasBlobs = true;
		String template = null;
		if(hasBlobs)
		   template = GeneUtil.readTemplate(GeneUtil.sqlTemplate_withBlobs);
		else 
		   template = GeneUtil.readTemplate(GeneUtil.sqlTemplate_withoutBlobs);
		// 进行模板替换
//System.out.println("this.getClassName():"+this.getClassName());
//System.out.println("this.getTableName():"+this.getTableName());
//System.out.println("this.getPk():"+this.getPk());
//System.out.println("this.getPkValue():"+this.getPkValue());
//System.out.println("this.getColumnsList_select():"+this.getColumnsList_select());
//System.out.println("this.getColumns_withoutBlobs_List_select():"+this.getColumns_withoutBlobs_List_select());
//System.out.println("this.getColumnValuesList_insert():"+this.getColumnValuesList_insert());
//System.out.println("this.getPackageQuery():"+this.getPackageQuery());
//System.out.println("this.getResult_withoutBlobs():"+this.getResult_withoutBlobs());
//System.out.println("this.getResult_Blobs():"+this.getResult_Blobs());
//System.out.println("this.getWhere_Clause():"+this.getWhere_Clause());
//System.out.println("this.getUpdateSetClause():"+this.getUpdateSetClause());
        if(template!=null){        	
			if(vo.getClassName()!=null)
			    template = template.replaceAll("\\{\\[#className#\\]\\}",vo.getClassName());
			if(vo.getTableName()!=null)
			    template = template.replaceAll("\\{\\[#tableName#\\]\\}",vo.getTableName());
			if(vo.getPk()!=null)
			    template = template.replaceAll("\\{\\[#pk#\\]\\}",vo.getPk());
			if(vo.getPkValue()!=null)
			    template = template.replaceAll("\\{\\[#pkValue#\\]\\}",vo.getPkValue());
			if(vo.getPkProperty()!=null)
			    template = template.replaceAll("\\{\\[#pkProperty#\\]\\}",vo.getPkProperty());
			if(vo.getColumnsList_select()!=null)
			    template = template.replaceAll("\\{\\[#columnsList_select#\\]\\}",vo.getColumnsList_select());
			if(vo.getColumns_withoutBlobs_List_select()!=null)
			    template = template.replaceAll("\\{\\[#columns_withoutBlobs_List_select#\\]\\}",vo.getColumns_withoutBlobs_List_select());
			if(vo.getColumnValuesList_insert()!=null)
			    template = template.replaceAll("\\{\\[#columnValuesList_insert#\\]\\}",vo.getColumnValuesList_insert());
			if(vo.getPackageName()!=null)
			    template = template.replaceAll("\\{\\[#packageName#\\]\\}",vo.getPackageName());
			if(vo.getPackageQuery()!=null)
			    template = template.replaceAll("\\{\\[#packageQuery#\\]\\}",vo.getPackageQuery());
			if(vo.getResults()!=null)
				template = template.replaceAll("\\{\\[#results#\\]\\}",vo.getResults());
			if(vo.getResult_withoutBlobs()!=null)
			    template = template.replaceAll("\\{\\[#result_withoutBlobs#\\]\\}",vo.getResult_withoutBlobs());
			if(vo.getResult_Blobs()!=null)
			    template = template.replaceAll("\\{\\[#result_Blobs#\\]\\}",vo.getResult_Blobs());
			if(vo.getWhere_Clause()!=null)
			    template = template.replaceAll("\\{\\[#where_Clause#\\]\\}",vo.getWhere_Clause());
			if(vo.getUpdateSetClause()!=null)
			    template = template.replaceAll("\\{\\[#updateSetClause#\\]\\}",vo.getUpdateSetClause());
			// 写入sql文件
			if(!GeneUtil.writeFile(GeneUtil.FilesDirDest_sql+vo.getTableName()+".xml", template))
				errs.append("写文件时出错！");
        }else
        	errs.append("找不到sqlTemplate的模板！");
//System.out.println(template);
        return errs.toString();
	}
	
	/**
	 * 生成所有文件的sql的xml文件
	 */
	public void doAll(){
		File[] files = GeneUtil.getFiles();
		StringBuffer errs = new StringBuffer("日至：\n");
		if(files!=null&&files.length>0)
		for(int i=0;i<files.length;i++){
			errs.append(printSqlFile(files[i]));
			errs.append("\n");
		}
		System.out.println(errs.toString());
	}
	
//	public static void modifyDocument(File inputXml){
//
//		  try{
//		   SAXReader saxReader = new SAXReader();
//		   Document document = saxReader.read(inputXml);
//
//		   List list = document.selectNodes("//sqlMap/resultMap" );
//System.out.println("list尺寸："+list.size());
//		   Iterator iter=list.iterator();
//		   
//		   String property = "";
//		   String jdbcType = "";
//		   String column = "";
//		   
//		   StringBuffer buffer = new StringBuffer();
//		   
//		   // 根据每个<resultMap中的名称和类型构造出where语句中的条件语句。例如
//		   // <isGreaterThan 语句
//		   while(iter.hasNext()){
//			   Element element=(Element)iter.next();
//               Iterator ite_result = element.elementIterator();
//               while(ite_result.hasNext()){
//            	   Element element_result = (Element)ite_result.next();
//               
//			   property = element_result.attribute("property").getValue(); 
//			   jdbcType = element_result.attribute("jdbcType").getValue();
//			   column = element_result.attribute("column").getValue();
//			   
//			   String colmnClause = getColumnClause(column,property,jdbcType);
//			   if(colmnClause!=null)
//				   buffer.append(colmnClause+"\n");
//               }
//		   }
//		   
//           // 定位<sql>下的<dynamic>标签，把<dynamic标签下的所有Element删除，用新生成的语句代替
//		   Element element_sql = (Element)document.selectSingleNode("//sqlMap/sql");
//		   Element element_dynamic = (Element)document.selectSingleNode("//sqlMap/sql/dynamic");
//		   element_sql.remove(element_dynamic);
//		   String dynamic_str = "    <dynamic prepend=\"where\" >\n"+buffer.toString()+"    </dynamic>";
//		   Element dynamic = DocumentHelper.parseText(dynamic_str).getRootElement();
//		   element_sql.add(dynamic);
//System.out.println(dynamic_str);
//
//          // 写入xml文件
//           OutputFormat format = OutputFormat.createPrettyPrint();
//           XMLWriter output = new XMLWriter(new FileWriter(inputXml),format);
//	       output.write(document);
//	       output.close();
//		  }		 
//		  catch(DocumentException e){
//		      System.out.println("出现异常：："+e.getMessage());
//		  }
//		  catch(IOException e){
//			  System.out.println("出现异常：："+e.getMessage());
//		  }
//		 }
//	
//	/**
//	 * 根据属性名和jdbcType构造出一列的比较sql语句，如<isGreateThan...
//	 * @param property
//	 * @param jdbcType
//	 * @return
//	 */
//	public static String getColumnClause(String column,String property,String jdbcType){
//		if(property==null)
//			return "";
//		
//		String columnClause = "";
//		
//		if(jdbcType==null||jdbcType.trim().length()<=0){
//			columnClause = "      <isNotNull prepend=\"and\" property=\""+property+"\">"
//            + "<![CDATA[ "+column+"=#"+property+"# ]]></isNotNull>";
//			return columnClause;
//		}
//			
//		jdbcType = jdbcType.trim();
//		columnClause = "      <isNotNull prepend=\"and\" property=\""+property+"\">"
//            + "<![CDATA[ "+column+"=#"+property+":" +jdbcType+ "# ]]></isNotNull>";
//		return columnClause;
//	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        GeneSql changeSql = new GeneSql();
        changeSql.doAll();
//        String src = "    update {[#tableName#]} pppppp";
//        String src_2 = src.replaceAll("\\{\\[#tableName#\\]\\}", "1234");
//        System.out.println("src::"+src_2);
	}

}
