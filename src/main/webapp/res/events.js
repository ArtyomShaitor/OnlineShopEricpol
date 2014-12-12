/**
 * Created by Artyom on 24.11.2014.
 */

$(document).ready(function(){

    checkCartStatus();


    $("a[name=cart]").click(function(){
        if ( $(".ericpol-cart").hasClass("close") ) $(".ericpol-cart").removeClass("close"); else $(".ericpol-cart").addClass("close");
    });

    $("input[type=button].in-bucket").click(function(){
       id = $(this).attr("id");
        $.ajax({
            url : "/throwIntoCart",
            type : "GET",
            data : "id="+id,
            success : function(data){
//                array = JSON.parse(data);
//                console.log(" - clicked");
//                setToSession(array);
//                checkCartStatus();

                console.log(" - clicked");
                window.localStorage.setItem(id, data);
                checkCartStatus();

            }
        })
    });



});

getFromSession = function(Key){
//    console.log(" -- getFromSession function enter:");
//    console.log(" Key = ", typeof(Key));
//    if (typeof (Key) != "number") Key = parseInt(Key);
//    console.log(" Key = ", typeof(Key));
//    item = window.localStorage.getItem(Key);
//    console.log(" item = ", item);
//    return JSONToArray(item);

    item = window.localStorage.getItem(Key);
    return JSON.parse(item);

};

setToSession = function(array){
//    json = ArrayToJSON(array);
//    id = array["id"];
//    if (typeof(id) != "number") id = parseInt(id);
//    window.localStorage.setItem(id, json);

    data = JSON.stringify(array);
    window.localStorage.setItem(array["id"], data);
};


cleanLocalStorage = function(){
    window.localStorage.clear();
};


checkCartStatus = function(){
    console.log(" -- Checking...");
    $(".table.table-striped.table-hover").children().remove();
    if (window.localStorage.length == 0){
        $(".table.table-striped.table-hover").append("<h3>Your cart is empty</h3>");
        $("#in-bucket").attr("disabled", true);
    }
    else{
        $(".table.table-striped.table-hover").append("<thead><tr><td>#</td><td>Title</td><td>Price</td></tr></thead>");
        sum = 0;
        i = 1;
        for (index in window.localStorage){
            item = window.localStorage.getItem(index);
            data = JSON.parse(item);
            console.log(data);
            sum += data["price"];
            $(".table.table-striped.table-hover").append("<tr> <td>"+i+"</td> <td>"+data["title"]+"</td> <td>"+data["price"]+"</td></tr>");
            i++;
        }
        $(".table.table-striped.table-hover").append("<thead><tr><td></td><td>Итого:</td><td>"+sum+"$</td></tr></thead>");
    }
};