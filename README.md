# Zapic React Native Demo

This example React Native app demonstrates integrating the Zapic SDK for Android.

```js
import Zapic from './zapic';

// Open the Zapic user interface.
Zapic.showDefaultPage();

// Get the current player ID.
Zapic.getPlayer(player => {
  if (player == null) {
    console.log('The current player has not logged in.');
  } else {
    console.log('The current player has logged in.');
    console.log('  Player ID: ' + player.playerId);
  }
});

// Submit a gameplay event.
Zapic.submitEvent(JSON.stringify({
  'CHARACTER': 'Plumber',
  'LEVEL': 10,
  'SCORE': 100000
}));
```
