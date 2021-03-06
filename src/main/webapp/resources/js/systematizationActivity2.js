var theMessage = "Attention, le groupe nominal que vous avez choisi ne correspond pas à la chaîne de coréférence que " +
    "vous avez choisie. Essayez encore.";

var success = ["Bravo !", "Excellent !", "Félicitations !", "Magnifique,bien joué !", "Excellent travail, félicitations !"];

var next = "Continuez pour trouver les element restants.";
var finish = "Vous avez fini avec succès!";


$(function () {
    var total = $("select").filter("#colorOption").size();
    for (var i = 1; i <= total; i++) {
        var box = $("#colorOption[name=c" + i + "]");
        box.find(":selected").val();
    }
});

var answers = [];
var rightAnswers = [];
function verifySelection(id,rightAnswer) {
    var option = $("#colorOption[name=" + id + "]").find(":selected").val();

    var index = $("#colorOption[name=" + id + "]").find(":selected").index();
    var lastBoxIndex = $("#colorOption[name=" + id + "]").find(":last").index();

    //Paint the box with the selected color
    $("#colorOption[name=" + id + "]").blur();

    //Finished?
    var total = getIndex($("select").filter("#colorOption").last().attr("name"));
    var trueTotal = $("select").filter("#colorOption").length;
    var missedBoxes = total - trueTotal;

    answers[getIndex(id)] = option;
    rightAnswers[getIndex(id)] = (option === rightAnswer) ? "true" : "false";

    var numOccurences = $.grep(rightAnswers, function (elem) {
        return typeof elem === 'undefined';
    }).length - 1;

    // Put the rights in another array, compare and if is all ok, continue
    // If not, disable the correct ones.
    if (numOccurences <= missedBoxes && answers.length > total) {
        $("#message").removeClass("warning");
        $("#message").addClass("warning").html(theMessage).show("shake", 500, callback);

        //Block the correct boxes
        for (var i = 1; i <= total + 1; i++) {
            if (rightAnswers[i - 1] === "true") {
                $("#colorOption[name=c" + i + "]").prop('disabled', 'disabled');
            }
        }
        if ($.inArray("false", rightAnswers) === -1) {
            $("#message").removeClass("warning");
            $("#message").addClass("success").text(success[Math.floor(Math.random() * success.length)] + finish).show("pulsate", 500);
            $("#next").fadeIn();
        }
    }
}
;

function getIndex(ref) {
    var split = ref.split("c");
    var id = parseInt(split[1]);
    return id - 1;
}
;

var callbackCalled = false;
function callback() {
    if (!callbackCalled) {
        callbackCalled = true;
        setTimeout(function () {
            $("#message").fadeOut();
            callbackCalled = false;
        }, 8000);
    }
}
;