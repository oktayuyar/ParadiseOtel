
var trh;
var rezTip;
var cocuk;
var yet;
var toplam;
var trh2;
var days = 0;

$(function () {
    var nowTemp = new Date();
    var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);


    var checkin = $('#rezervasyon\\:dp1').datepicker({
        onRender: function (date) {
            return date.valueOf() < now.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        if (ev.date.valueOf() > checkout.date.valueOf()) {
            var newDate = new Date(ev.date);
            newDate.setDate(newDate.getDate() + 1);
            checkout.setValue(newDate);
        }
        checkin.hide();
        $('#rezervasyon\\:dp1')[0].focus();
    }).data('datepicker');
    var checkout = $('#rezervasyon\\:dp1').datepicker({
        onRender: function (date) {
            return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        checkout.hide();
        trh = ev.date;
    }).data('datepicker');

    var checkin = $('#rezervasyon\\:dp2').datepicker({
        onRender: function (date) {
            return date.valueOf() < now.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        if (ev.date.valueOf() > checkout.date.valueOf()) {
            var newDate = new Date(ev.date);
            newDate.setDate(newDate.getDate() + 1);
            checkout.setValue(newDate);
        }
        checkin.hide();
        $('#rezervasyon\\:dp2')[0].focus();
    }).data('datepicker');
    var checkout = $('#rezervasyon\\:dp2').datepicker({
        onRender: function (date) {
            return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        checkout.hide();
        trh2 = ev.date;
        rezTip = $("#rezervasyon\\:room").val();
        cocuk = $("#rezervasyon\\:childp").val();
        yet = $("#rezervasyon\\:adultp").val();

        days = (trh2 - trh) / 1000 / 60 / 60 / 24;

        if (rezTip == 1) {
            toplam = days * ((yet * 100) + (cocuk * 50));
        } else if (rezTip == 2) {
            toplam = days * ((yet * 120) + (cocuk * 50));
        } else if (rezTip == 3) {
            toplam = days * ((yet * 150) + (cocuk * 50));
        }
        $("#rezervasyon\\:deger").val(toplam);
    }).data('datepicker');

});

function roomC() {

    rezTip = $("#rezervasyon\\:room").val();
    cocuk = $("#rezervasyon\\:childp").val();
    yet = $("#rezervasyon\\:adultp").val();

    if (rezTip == 1) {
        toplam = days * ((yet * 100) + (cocuk * 50));
    } else if (rezTip == 2) {
        toplam = days * ((yet * 120) + (cocuk * 50));
    } else if (rezTip == 3) {
        toplam = days * ((yet * 150) + (cocuk * 50));
    }
    $("#rezervasyon\\:deger").val(toplam);
}
function childpC() {

    rezTip = $("#rezervasyon\\:room").val();
    cocuk = $("#rezervasyon\\:childp").val();
    yet = $("#rezervasyon\\:adultp").val();

    if (rezTip == 1) {
        toplam = days * ((yet * 100) + (cocuk * 50));
    } else if (rezTip == 2) {
        toplam = days * ((yet * 120) + (cocuk * 50));
    } else if (rezTip == 3) {
        toplam = days * ((yet * 150) + (cocuk * 50));
    }
    $("#rezervasyon\\:deger").val(toplam);
}
function adultpC() {

    rezTip = $("#rezervasyon\\:room").val();
    cocuk = $("#rezervasyon\\:childp").val();
    yet = $("#rezervasyon\\:adultp").val();

    if (rezTip == 1) {
        toplam = days * ((yet * 100) + (cocuk * 50));
    } else if (rezTip == 2) {
        toplam = days * ((yet * 120) + (cocuk * 50));
    } else if (rezTip == 3) {
        toplam = days * ((yet * 150) + (cocuk * 50));
    }
    $("#rezervasyon\\:deger").val(toplam);
}
$(function () {
    var nowTemp = new Date();
    var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);

    var checkin = $('#anasayfa\\:dp3').datepicker({
        onRender: function (date) {
            return date.valueOf() < now.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        if (ev.date.valueOf() > checkout.date.valueOf()) {
            var newDate = new Date(ev.date);
            newDate.setDate(newDate.getDate() + 1);
            checkout.setValue(newDate);
        }
        checkin.hide();
        $('#anasayfa\\:dp3')[0].focus();
    }).data('datepicker');
    var checkout = $('#anasayfa\\:dp3').datepicker({
        onRender: function (date) {
            return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        checkout.hide();
        trh = ev.date;
    }).data('datepicker');

    var checkin = $('#anasayfa\\:dp4').datepicker({
        onRender: function (date) {
            return date.valueOf() < now.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        if (ev.date.valueOf() > checkout.date.valueOf()) {
            var newDate = new Date(ev.date);
            newDate.setDate(newDate.getDate() + 1);
            checkout.setValue(newDate);
        }
        checkin.hide();
        $('#anasayfa\\:dp4')[0].focus();
    }).data('datepicker');
    var checkout = $('#anasayfa\\:dp4').datepicker({
        onRender: function (date) {
            return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        checkout.hide();
        trh2 = ev.date;
    }).data('datepicker');

});


