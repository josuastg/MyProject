
import React from 'react';
import SplashScreen from './src/screen/SplashScreen';
import HomeScreen from './src/screen/HomeScreen';
import { createAppContainer } from 'react-navigation';
import combine from './src/reducers';
import { Provider } from 'react-redux';
import { createStore } from 'redux';
import { createStackNavigator } from 'react-navigation-stack';
import UpdatePersonScreen from './src/screen/UpdatePersonScreen';
import CreatePersonScreen from './src/screen/CreatePersonScreen';
import DetailPersonScreen from './src/screen/DetailPersonScreen';

const AppNavigator = createStackNavigator({
  SplashScreen: { screen: SplashScreen },
  HomeScreen: { screen: HomeScreen },
  UpdatePersonScreen: { screen: UpdatePersonScreen },
  CreatePersonScreen: { screen: CreatePersonScreen },
  DetailPersonScreen: { screen: DetailPersonScreen }

}, { headerMode: 'none' })

const AppContain = createAppContainer(AppNavigator);

export default function App() {

  return (
    <Provider store={createStore(combine)}>
      <AppContain />
    </Provider>
  );
}

