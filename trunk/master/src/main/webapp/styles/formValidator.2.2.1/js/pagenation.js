function DHTMLpagenation(content){
    with(this)
    {
        // client static html file pagenation
        
        this.content=content;        
        this.contentLength=content.length;        
        this.pageSizeCount;        
        this.perpageLength=100;
        //default perpage byte length.
        this.currentPage=1;        
        //this.regularExp=/.+[\?\&]{1}page=(\d+)/;
        this.regularExp=/\d+/;        
        this.pagenationStr = '_baidu_page_break_tag_';
        this.divDisplayContent;        
        this.contentStyle=null;        
        this.strDisplayContent="";        
        this.divDisplayPagenation;        
        this.strDisplayPagenation="";        
        
  //      arguments.length==2?perpageLength=arguments[1]:'';        
        
        try{
            
            divExecuteTime=document.createElement("DIV");            
            document.body.appendChild(divExecuteTime);            
            
        }
        catch(e)
        {
            
            
        }
        if(document.getElementById("divContent"))
        {
            
            divDisplayContent=document.getElementById("divContent");            
            
        }
        else 
        {
            
            try
            {
                
                divDisplayContent=document.createElement("DIV");                
                divDisplayContent.id="divContent";                
                document.body.appendChild(divDisplayContent);                
                
            }
            catch(e)
            {
                
                return false;                
                
            }
            
        }
        
        if(document.getElementById("divPagenation"))
        {
            
            divDisplayPagenation=document.getElementById("divPagenation");            
            
        }
        else 
        {
            
            try
            {
                
                divDisplayPagenation=document.createElement("DIV");                
                divDisplayPagenation.id="divPagenation";                
                document.body.appendChild(divDisplayPagenation);                
                
            }
            catch(e)
            {
                
                return false;                
                
            }
            
        }
        
        DHTMLpagenation.initialize();        
        return this;        
        
        
    }
};
DHTMLpagenation.initialize=function (){
    with(this)
    {
        
        divDisplayContent.className=contentStyle!=null?contentStyle:"divContent";        
    

        pageSizeCount=(content.split(pagenationStr)).length;
        if(pageSizeCount<=1)
        {
            
            strDisplayContent=content;            
            divDisplayContent.innerHTML=strDisplayContent;            
            return null;            
            
        }
        DHTMLpagenation.goto(currentPage);        
        DHTMLpagenation.displayContent();        
        
    }
};
DHTMLpagenation.displayPage=function (){
    with(this)
    {
        
        strDisplayPagenation='<div class="pagination">';        
        
        if(currentPage&&currentPage!=1)
        strDisplayPagenation+='<a class="page" href="javascript:void(0)" onclick="DHTMLpagenation.previous()"><</a>';        
        else 
        strDisplayPagenation+='<span><</span>';        
        
        for(var i=1;i<=pageSizeCount;i++)
        {
            
            if(i!=currentPage)
            strDisplayPagenation+='<a class="page" href="javascript:void(0)" onclick="DHTMLpagenation.goto('+i+');">'+i+'</a>';            
            else 
            strDisplayPagenation+='<span class="vis">'+i+'</span>';            
            
        }
        
        if(currentPage&&currentPage!=pageSizeCount)
        strDisplayPagenation+='<a href="javascript:void(0)" onclick="DHTMLpagenation.next()">></a>';        
        else 
        strDisplayPagenation+="<span>></span>";        
        if(currentPage!=-1)
        	strDisplayPagenation+='<a href="javascript:void(0)" onclick="DHTMLpagenation.all()">在本页阅读全文</a>';        
        else
            strDisplayPagenation+='<span class="vis">在本页阅读全文</span>';        

        strDisplayPagenation+='</div>'
        divDisplayPagenation.innerHTML=strDisplayPagenation;        
        
    }
};
DHTMLpagenation.previous=function (){
    with(this)
    {
        
        DHTMLpagenation.goto(currentPage-1);        
        
    }
};
DHTMLpagenation.next=function (){
    with(this)
    {
        
        DHTMLpagenation.goto(currentPage+1);        
        
    }
};
DHTMLpagenation.all=function (){
    with(this)
    {
        
        DHTMLpagenation.goto(-1);        
        
    }
};
DHTMLpagenation.goto=function (iCurrentPage){
    with(this)
    {
        startime=new Date();        
        if(regularExp.test(iCurrentPage)){
            currentPage=iCurrentPage;
            if(iCurrentPage==-1)
                strDisplayContent = content.replace(pagenationStr,'');
            else
                strDisplayContent = findSubContent(content,pagenationStr,currentPage)

        }else {
            alert("page parameter error!");            
        }
        DHTMLpagenation.displayPage();        
        DHTMLpagenation.displayContent();        
		var h = $(".main_right").height();
		var menu_h = $(".main_left",parent.document).height();
		var height = Math.max(h,menu_h);
		$("#mainRightBox",parent.document).height(height+10+"px");
		$("#mainFrame",parent.document).height(height+10+"px");
		$("#mainFrameBox",parent.parent.document).height(height+20+"px");	
	    $("#mainFrame",parent.parent.document).height(height+20+"px");	   
    }
};

DHTMLpagenation.findSubContent = function (content,pagenationStr,pageNo){
	with(this)
{
    var offsetStart = 0;        
    for(var i=0;i<pageNo-1;i++){
    	offsetStart = content.indexOf(pagenationStr, offsetStart);
    	if(offsetStart != -1){
    		  offsetStart += pagenationStr.length;
	    }
    }
    var offsetEnd = content.indexOf(pagenationStr, offsetStart);
    if(offsetEnd == -1){
    	offsetEnd = content.length;
    }
	var subContent = content.substring(offsetStart,offsetEnd);
    return subContent;
}
};
DHTMLpagenation.displayContent=function (){
    with(this)
    {
        
        divDisplayContent.innerHTML=strDisplayContent;        
        
    }
};
DHTMLpagenation.change=function (iPerpageLength){
    with(this)
    {
        
        if(regularExp.test(iPerpageLength))
        {
            
            DHTMLpagenation.perpageLength=iPerpageLength;            
            DHTMLpagenation.currentPage=1;            
            DHTMLpagenation.initialize();            
            
        }
        else 
        {
            
            alert("请输入数字");            
            
        }
        
    }
};

