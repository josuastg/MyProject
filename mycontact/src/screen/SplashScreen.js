import React, { Component } from 'react';
import {View, Text,Image, StyleSheet, StatusBar} from 'react-native'
export default class SplashScreen extends Component {
    componentDidMount(){
        setTimeout(() =>{
            this.props.navigation.navigate('HomeScreen');
        }, 2000)
    }
  render() {
    return (
      <View style={styles.background}>
          <View style={styles.viewImageStyle}>
          <StatusBar backgroundColor="#00BFFF" barStyle="light-content"></StatusBar>
          <Image style={styles.imageStyle} source={require('../assets/contact.png')}></Image>
          </View>
          <Text style={styles.textStyle}>Let's Explore your contact </Text>
      </View>
    );
  }
}
const styles = StyleSheet.create({
    background : {
        backgroundColor : 'rgb(0,191,255)',
        flex : 1,
        justifyContent: 'center'
    },
    textStyle: {
        color: '#fff',
        fontSize : 20,
        fontWeight : 'bold',
        textAlign: 'center'
    },
    imageStyle: {
        width: 120,
        height: 120,
        alignSelf: 'center',
        marginBottom: 10
    },
    viewImageStyle:{
        marginTop: 10,
        marginBottom: 10
    }
})
