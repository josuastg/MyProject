import React, { Component } from 'react';
import { View, Text, KeyboardAvoidingView, ScrollView, Linking } from 'react-native';
import { Avatar, Header, Button, Input } from 'react-native-elements';
import { connect } from 'react-redux';
import * as Service from '../services/ContactService.js';
import Icon from 'react-native-vector-icons/Ionicons';
import { FETCH_DETAIL_USER_SUCCESS, FETCH_DETAIL_USER_ERROR } from '../action/Contact.js';
import { Spinner } from 'native-base';


class UpdatePersonScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {
      firstName: this.props.data.firstName,
      lastName: this.props.data.lastName,
      age: this.props.data.age,
      photo: this.props.data.photo
    }
  }


  detailContact() {
    const { dispatch } = this.props;
    const { id } = this.props.data;
    Service.detailContact(id)
      .then((data) => {
        dispatch({ type: FETCH_DETAIL_USER_SUCCESS, loading: false, data: data })
      })
      .catch((error) => {
        dispatch({ type: FETCH_DETAIL_USER_ERROR, loading: false, error: error })
      })

  }




  handleChangeFirstName = (event) => {
    this.setState({ firstName: event })
  }

  handleChangeLastName = (event) => {
    this.setState({ lastName: event })
  }

  handleChangeAge = (event) => {
    this.setState({ age: event })
  }

  handleChangePhoto = (event) => {
    this.setState({ photo: event })
  }

  handleSubmit = async () => {
    const { id } = this.props.data;
    const data = await Service.putContact(id, this.state);
    console.log("HASIL UPDATE", data);
    this.props.navigation.navigate('HomeScreen');

  }



  componentDidMount() {
    this.detailContact();
  }



  render() {
    const { data } = this.props;
    return (

      <KeyboardAvoidingView>

        <ScrollView>
          <View>
            <Header
              statusBarProps={{ barStyle: 'light-content' }}
              barStyle="light-content"
              rightComponent={<Button onPress={this.handleSubmit} type="clear" icon={<Icon name='md-checkmark' color='#ffffff' size={25} />} />}
              leftComponent={<Button onPress={() => { this.props.navigation.navigate('HomeScreen') }} type="clear" icon={<Icon name='md-close' color='#ffffff' size={25} />} />}
              centerComponent={{ text: 'EDIT CONTACT', style: { color: '#fff', fontSize: 20, fontWeight: 'bold' } }}
              containerStyle={{
                backgroundColor: '#00BFFF',
                justifyContent: "space-around"
              }}
            />
            {data ?
              <View style={{ padding: 5 }}>
                <View style={{ alignItems: 'center', marginTop: 30 }}>
                  <Avatar
                    rounded
                    activeOpacity={0.10}
                    size="xlarge"
                    source={{
                      uri: data.photo
                    }} />
                </View>
                <View style={{ padding: 10, marginTop: 50 }}>
                  <Input
                    placeholder='Link URL photo'
                    rightIcon={<Button type="clear" title="Find" onPress={() => Linking.openURL('https://www.google.com/imghp?hl=en').catch((error) => console.error('An error occured', error))} />}
                    defaultValue={data.photo}
                    leftIcon={<Icon name="md-image" size={25} color="#00BFFF" />}
                    onChangeText={this.handleChangePhoto}
                  />
                  <Input
                    placeholder='Firstname'
                    defaultValue={data.firstName}
                    leftIcon={<Icon name="md-person" size={25} color="#00BFFF" />}
                    onChangeText={this.handleChangeFirstName}
                  />
                  <Input
                    placeholder='Lastname'
                    onChangeText={this.handleChangeLastName}
                    defaultValue={data.lastName}
                    leftIcon={<Icon name="md-person" size={25} color="#00BFFF" />}
                  />
                  <Input
                    placeholder='Age'
                    keyboardType='numeric'
                    onChangeText={this.handleChangeAge}
                    leftIcon={<Icon name="md-person" size={25} color="#00BFFF" />}
                  >
                    <Text>{data.age}</Text>
                  </Input>

                </View>
              </View>
              : <Spinner />}

          </View>
        </ScrollView>
      </KeyboardAvoidingView>

    );
  }
}
function mapStateToProps(state) {

  return { ...state.findDetailContact }
}
export default connect(mapStateToProps)(UpdatePersonScreen);

