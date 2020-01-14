/**
 * Created by dell on 2018/5/20.
 */
function $1(id){
    return document.getElementById(id);
}
//获取标签中的文本信息
function txt(obj){
    return obj.innerText;
}
function productCount(){
    var total=0;//总价格
    var save=0;//节省价格
    var intergal=0;//积分
    var point=0;//单品积分
    var price=0;//市场价格
    var ddprice=0;//当当价格
    var num=0;//购买数量

    var trs=$1('mytable').getElementsByTagName('tr');
    //循环获取每行的值
    for(var i=0;i<trs.length;i++){
        point=txt(trs[i].getElementsByTagName('td')[1]);//获取到第i行的第二列的文本信息
        price=txt(trs[i].getElementsByTagName('td')[2].getElementsByTagName('label')[0]);
        ddprice=txt(trs[i].getElementsByTagName('td')[3].getElementsByTagName('label')[0]);
        num=trs[i].getElementsByTagName('td')[4].getElementsByTagName('input')[0].value;
        if(isNaN(num)){
            alert('您输入的数量有误....');
            trs[i].getElementsByTagName('td')[4].getElementsByTagName('input')[0].select();
            return;
        }
        intergal +=point*num;
        //if(ddprice*num<98){
        if(price==ddprice){
        	total +=ddprice*num;
        	 save+=(price-ddprice)*num;
        }else{
        	total +=ddprice*num-50;
       	 	save+=50;
        }
      //  }else{
        //    total +=ddprice*num-50;
       	 //save+=50;
        //}
       

    }
    $1('mytotal').value=total.toFixed(2);
    $1('mysave').innerHTML=save.toFixed(2);
    $1('mypoint').innerHTML=intergal;

}

//删除购物车中的信息
function deleteObj(id){
    $1('mytable').getElementsByTagName('tbody')[0].removeChild($1(id));

    productCount();
}
//显示购物车背景

function show(){
    var trs=$1('mytable').getElementsByTagName('tr');
    for(var i=0;i<trs.length;i++) {
        trs.item(i).onmouseover = function () {
            this.style.background = 'wihte';
        }
        trs.item(i).onmouseout = function () {
            this.style.background = 'wihte';
        }
    }
}
//隐藏或显示层
function changeStyle(id,divid){
    var imgObj=$1(id);
    var divObj=$1(divid);
    if(divObj.style.display=='block'){
        divObj.style.display='none';
        imgObj.src='images/shopping_arrow_down.gif';
    }else{
        divObj.style.display='block';
        imgObj.src='images/shopping_arrow_up.gif';
    }
}
//对文本框输入的值进行判断,只能输出数字
function checkValue(){
    var str=document.getElementsByClassName('shopping_product_list_5');
    console.log(str);
}

window.onload=function(){
    productCount();
    show();
    checkValue();
    //获取所有购买标签 给其添加点击事情
    var alls=document.getElementsByClassName('shopping_yellow');
    for(var i=0;i<alls.length;i++){
        alls.item(i).onclick=function(){

            var mytr=document.createElement('tr');
            mytr.setAttribute('class','shopping_product_list');
            var mydate=new Date();
            myid=''+mydate.getFullYear()+(mydate.getMonth()+1)+mydate.getDate()+mydate.getHours()+mydate.getMinutes()+
                    mydate.getSeconds()+mydate.getTime();
            mytr.setAttribute('id',myid);
            var mytd=document.createElement('td');
            //获取书名
            var bname=txt(this.parentNode.parentNode.getElementsByTagName('li')[0]).substr(1);

            //检查书名是否存在
            if(checkBookName(bname)){

                return;
            }
            mytd.setAttribute('class','shopping_product_list_1');
            var str='<a href="#" class="blue">'+bname+'</a>';
            mytd.innerHTML=str;
            mytr.appendChild(mytd);
            //获取价格,当当价
            var price=txt(this.parentNode.parentNode.getElementsByTagName('li')[1]).substr(1);
            var ddprice=txt(this.parentNode.parentNode.getElementsByTagName('li')[2]).substr(1);
            //积分
            mytd=document.createElement('td');
            mytd.setAttribute('class','shopping_product_list_2');
            mytd.innerHTML=ddprice*10;
            mytr.appendChild(mytd);

            //价格
            mytd=document.createElement('td');
            mytd.setAttribute('class','shopping_product_list_3');
            str='￥<label>'+price+'</label>';
            mytd.innerHTML=str;
            mytr.appendChild(mytd);
            //当当价格
            mytd=document.createElement('td');
            mytd.setAttribute('class','shopping_product_list_4');
            str='￥<label>'+ddprice+'</label> ('+((ddprice/price).toFixed(2))*100+'折)';
            mytd.innerHTML=str;
            mytr.appendChild(mytd);
            //数量
            mytd=document.createElement('td');
            mytd.setAttribute('class','shopping_product_list_5');
            str='<input type="text" value="1" onBlur="productCount()"/>';
            mytd.innerHTML=str;
            mytr.appendChild(mytd);
            //删除
            mytd=document.createElement('td');
            mytd.setAttribute('class','shopping_product_list_6');
            str='<a href="javascript:deleteObj(\''+myid+'\')" class="blue">删除</a>';
            mytd.innerHTML=str;
            mytr.appendChild(mytd);
            $1('mytable').getElementsByTagName('tbody')[0].appendChild(mytr);
            productCount();
        }
    }
}
function checkBookName(name){
    var trs=$1('mytable').getElementsByTagName('tr');
    var s;
    var val=0;
    for(var i=0;i<trs.length;i++){
        s=txt(trs[i].getElementsByTagName('td')[0]);

        if(s==name){
            val=trs[i].getElementsByTagName('td')[4].getElementsByTagName('input')[0].value;
            trs[i].getElementsByTagName('td')[4].getElementsByTagName('input')[0].value=++val;
            productCount();
            show();
            return true;
        }
    }
    return false;
}

function change12(id,divid){
   var s= $1(id).innerText;
    var s1=$1(divid).innerText;


   if(s1=='下架') {
       $1(id).innerText = '已下架';
       $1(divid).innerText = '上架';
       $1(divid).style.text

   }else if(s1=='上架')
    {
        $1(id).innerText = '上架';
        $1(divid).innerText = '下架';

    }
}
