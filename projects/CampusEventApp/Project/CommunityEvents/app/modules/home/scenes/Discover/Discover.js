import React, { Component } from 'react';
import { FlatList, TouchableOpacity, Image } from 'react-native';
import { Container, Content, Card, Header, CardItem, Left, Right, Title, Body, Text, Button } from 'native-base';
import {Actions} from 'react-native-router-flux';
import Spacer from './Spacer';


class Discover extends Component {
  render(){
  return (
    <Container>
      <Header style={{backgroundColor:"#ff4d4d"}}>
        <Left style={{ flex: 1}} />
        <Body style={{ flex: 1, justifyContent: 'center', alignItems: 'center'}}>
        <Title>Discover</Title>
        </Body>
        <Right style={{ flex: 1}} />
      </Header>

      <Content padder>
        <Card transparent style={{ paddingHorizontal: 6 }}>
              <CardItem cardBody>
                <TouchableOpacity onPress={Actions.Sports} style={{ flex: 1 }}>
                  <Image
                    source={ require("CommunityEvents/img/DiscoverScreen/sports.jpg") }
                    style={{
                      height: 100,
                      width: null,
                      flex: 1,
                      borderRadius: 5,
                    }}
                  />
                </TouchableOpacity>
              </CardItem>
              <CardItem cardBody>
                <Body>
                <Spacer size={10} />
                  <Text style={{ fontWeight: '800', alignSelf: 'center' }}>Sports</Text>
                  <Spacer size={15} />
                  <Button
                    block
                    bordered
                    small
                    onPress={Actions.Sports}
                  >
                    <Text>View Events</Text>
                  </Button>
                  <Spacer size={5} />
                </Body>
              </CardItem>
              <CardItem cardBody>
                <TouchableOpacity onPress={Actions.Volunteers} style={{ flex: 1 }}>
                  <Image
                    source={ require("CommunityEvents/img/DiscoverScreen/volunteers.jpg") }
                    style={{
                      height: 100,
                      width: null,
                      flex: 1,
                      borderRadius: 5,
                    }}
                  />
                </TouchableOpacity>
              </CardItem>
              <CardItem cardBody>
                <Body>
                <Spacer size={10} />
                  <Text style={{ fontWeight: '800', alignSelf: 'center' }}>Volunteers</Text>
                  <Spacer size={15} />
                  <Button
                    block
                    bordered
                    small
                    onPress={Actions.Volunteers}
                  >
                    <Text>View Events</Text>
                  </Button>
                  <Spacer size={5} />
                </Body>
              </CardItem>
              <CardItem cardBody>
                <TouchableOpacity onPress={Actions.Lectures} style={{ flex: 1 }}>
                  <Image
                    source={ require("CommunityEvents/img/DiscoverScreen/lecture.jpg") }
                    style={{
                      height: 100,
                      width: null,
                      flex: 1,
                      borderRadius: 5,
                    }}
                  />
                </TouchableOpacity>
              </CardItem>
              <CardItem cardBody>
                <Body>
                <Spacer size={10} />
                  <Text style={{ fontWeight: '800', alignSelf: 'center' }}>Lectures or Presentation</Text>
                  <Spacer size={15} />
                  <Button
                    block
                    bordered
                    small
                    onPress={Actions.Lectures}
                  >
                    <Text>View Events</Text>
                  </Button>
                  <Spacer size={5} />
                </Body>
              </CardItem>
              <CardItem cardBody>
                <TouchableOpacity onPress={Actions.Workshops} style={{ flex: 1 }}>
                  <Image
                    source={ require("CommunityEvents/img/DiscoverScreen/conference.jpg") }
                    style={{
                      height: 100,
                      width: null,
                      flex: 1,
                      borderRadius: 5,
                    }}
                  />
                </TouchableOpacity>
              </CardItem>
              <CardItem cardBody>
                <Body>
                <Spacer size={10} />
                  <Text style={{ fontWeight: '800', alignSelf: 'center' }}>Conference or Workshop</Text>
                  <Spacer size={15} />
                  <Button
                    block
                    bordered
                    small
                    onPress={Actions.Workshops}
                  >
                    <Text>View Events</Text>
                  </Button>
                  <Spacer size={5} />
                </Body>
              </CardItem>
        </Card>
      </Content>
    </Container>
  );
}
}

export default Discover;
