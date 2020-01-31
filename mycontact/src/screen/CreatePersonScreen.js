import React, { Component } from 'react';
import { View, Text, KeyboardAvoidingView, ScrollView, Linking } from 'react-native';
import { Header, Button, Avatar, Input } from 'react-native-elements'
import Icon from 'react-native-vector-icons/Ionicons';
import * as Service from '../services/ContactService.js';
import { connect } from 'react-redux';
import { HANDLE_AGE_USER, HANDLE_FIRSTNAME_USER, HANDLE_LASTNAME_USER, HANDLE_PHOTO_USER } from '../action/Contact.js';
class CreatePersonScreen extends Component {



    handleSubmit = async () => {
        await Service.postContact(this.props.data)
        this.props.navigation.navigate('HomeScreen');

    }

    handleAgeUser = (event) => {
        console.log('age', event)
        let data = event;
        this.props.dispatch({ type: HANDLE_AGE_USER, contact: data })
    }


    handleFirstNameUser = (event) => {
        console.log('firstName', event)
        let data = event;
        this.props.dispatch({ type: HANDLE_FIRSTNAME_USER, contact: data })
    }

    handleLastNameUser = (event) => {
        console.log('LastName', event)
        let data = event;
        this.props.dispatch({ type: HANDLE_LASTNAME_USER, contact: data })
    }
    handlePhotoUser = (event) => {
        console.log('photo', event)
        let data = event;
        this.props.dispatch({ type: HANDLE_PHOTO_USER, contact: data })
    }

    render() {
        return (
            <KeyboardAvoidingView>
                <ScrollView>
                    <View>
                        <Header
                            statusBarProps={{ barStyle: 'light-content' }}
                            barStyle="light-content"
                            rightComponent={<Button onPress={this.handleSubmit} type="clear" icon={<Icon name='md-checkmark' color='#ffffff' size={25} />} />}
                            leftComponent={<Button onPress={() => { this.props.navigation.navigate('HomeScreen') }} type="clear" icon={<Icon name='md-close' color='#ffffff' size={25} />} />}
                            centerComponent={{ text: 'ADD CONTACT', style: { color: '#fff', fontSize: 20, fontWeight: 'bold' } }}
                            containerStyle={{
                                backgroundColor: '#00BFFF',
                                justifyContent: 'center',
                            }}
                        />
                        <View>
                            <View style={{ alignItems: 'center', marginTop : 50 }}>
                                <Avatar
                                    rounded
                                    activeOpacity={0.10}
                                    size="xlarge"
                                    source={{
                                        uri:
                                            'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzNRDYUoU4HrUL9GGMsuM8xJEy9tSHfZQ8gYoyWSEdGlqou_7s',
                                    }} />
                            </View>
                            <View style={{ padding: 10, marginTop: 50 }}>
                                <Input
                                    placeholder='Link URL photo'
                                    onChangeText={this.handlePhotoUser}
                                    rightIcon={<Button type="clear" title="Find" onPress={() => Linking.openURL('https://www.google.com/imghp?hl=en').catch((error) => console.error('An error occured', error))} />}
                                    leftIcon={<Icon name="md-image" size={25} color="#00BFFF" />}
                                />
                                <Input
                                    placeholder='Firstname'
                                    onChangeText={this.handleFirstNameUser}
                                    leftIcon={<Icon name="md-person" size={25} color="#00BFFF" />}
                                />
                                <Input
                                    placeholder='Lastname'
                                    onChangeText={this.handleLastNameUser}
                                    leftIcon={<Icon name="md-person" size={25} color="#00BFFF" />}
                                />
                                <Input
                                    onChangeText
                                    placeholder='Age'
                                    keyboardType='numeric'
                                    onChangeText={this.handleAgeUser}
                                    leftIcon={<Icon name="md-person" size={25} color="#00BFFF" />}
                                >
                                    <Text></Text>
                                </Input>

                            </View>
                        </View>
                    </View>
                </ScrollView>
            </KeyboardAvoidingView>
        );
    }
}

function mapStateToProps(state) {
    return { ...state.saveContact }
}

export default connect(mapStateToProps)(CreatePersonScreen);