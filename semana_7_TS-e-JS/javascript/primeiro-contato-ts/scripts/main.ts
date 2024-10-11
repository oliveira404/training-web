enum Direction {
  ADMIN = 'ADMIN',
  USER = 'USER'
}

function handleMovement(direction: Direction) {
  if (direction === Direction.ADMIN) {
    console.log(direction);
  }
}

handleMovement(Direction.ADMIN);