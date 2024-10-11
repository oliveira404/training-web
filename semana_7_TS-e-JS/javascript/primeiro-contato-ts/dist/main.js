"use strict";
var Direction;
(function (Direction) {
    Direction["ADMIN"] = "ADMIN";
    Direction["USER"] = "USER";
})(Direction || (Direction = {}));
function handleMovement(direction) {
    if (direction === Direction.ADMIN) {
        console.log(direction);
    }
}
handleMovement(Direction.ADMIN);
