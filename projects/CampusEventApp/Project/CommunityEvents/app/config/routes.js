import React from 'react';
import { Scene, Router, ActionConst, Stack, Modal, Tabs } from 'react-native-router-flux';
import { Icon } from 'native-base';

//Splash Component
import Splash from '../components/Splash/Splash';

//Authentication Scenes
import Welcome from '../modules/auth/scenes/Welcome';
import Register from '../modules/auth/scenes/Register';
import CompleteProfile from '../modules/auth/scenes/CompleteProfile';
import Login from '../modules/auth/scenes/Login';
import ForgotPassword from '../modules/auth/scenes/ForgotPassword';
import CalendarView from '../modules/home/scenes/CalendarView';
import GridView from '../modules/home/scenes/GridView';
import ListView from '../modules/home/scenes/ListView';
import Discover from '../modules/home/scenes/Discover';
import Sports from '../modules/home/scenes/Discoverdetails/Sports';
import Volunteers from '../modules/home/scenes/Discoverdetails/Volunteer';
import Lectures from '../modules/home/scenes/Discoverdetails/Lecture';
import Workshops from '../modules/home/scenes/Discoverdetails/Workshop';
import Following from '../modules/home/scenes/Following';
import Profile from '../modules/home/scenes/Profile/Profile';

//Import Store, actions
import store from '../redux/store'
import { checkLoginStatus } from "../modules/auth/actions";

import { eventsProps, stackProps, eventtabProps, eventtabIconStyle, tabIconStyle, tabProps, color, navTitleStyle } from "../styles/theme";

export default class extends React.Component {
    constructor() {
        super();
        this.state = {
            isReady: false,
            isLoggedIn: false
        }
    }

    componentDidMount() {
        let _this = this;
        store.dispatch(checkLoginStatus((isLoggedIn) => {
            _this.setState({isReady: true, isLoggedIn});
        }));
    }

    render() {
        if (!this.state.isReady)
            return <Splash/>

        return (
            <Router>
                <Scene key="root" hideNavBar
                       navigationBarStyle={{backgroundColor: "#fff"}}
                       titleStyle={navTitleStyle}
                       backButtonTintColor={color.black}>
                    <Stack key="Auth" initial={!this.state.isLoggedIn}>
                        <Scene key="Welcome" component={Welcome} title="" initial={true} hideNavBar/>
                        <Scene key="Register" component={Register} title="Register" back/>
                        <Scene key="CompleteProfile" component={CompleteProfile} title="Select Username" back={false}/>
                        <Scene key="Login" component={Login} title="Login"/>
                        <Scene key="ForgotPassword" component={ForgotPassword} title="Forgot Password"/>
                    </Stack>

                    <Stack key="Main" hideNavBar initial={this.state.isLoggedIn}>
                    <Tabs key="tabbar" type="replace" showLabel={true} {...tabProps} initial={true}>
                    <Stack key="Events" hideNavBar={false} title="My Events" tabBarLabel="Events" icon={() => <Icon name="globe" {...tabIconStyle}/>} {...stackProps}>
                    	<Tabs key="EventsTabbar" type="replace" {...eventtabProps}>
                    		<Stack key="Calendar" icon={() => <Icon ios="ios-calendar" android="md-calendar" {...eventtabIconStyle}/>}>
                        		<Scene key="CalendarView" component={CalendarView} hideNavBar/>
                       		</Stack>
                       		<Stack key="GridView" icon={() => <Icon ios="ios-grid" android="md-grid" {...eventtabIconStyle}/>}>
                        		<Scene key="GridView" component={GridView} hideNavBar/>
                       		</Stack>
                       		<Stack key="ListView" icon={() => <Icon ios="ios-list" android="md-list" {...eventtabIconStyle}/>}>
                        		<Scene key="ListView" component={ListView}  hideNavBar/>
                       		</Stack>
                       	</Tabs>
                    </Stack>
                    <Stack key="Discover" title="Discover" icon={() => <Icon ios="ios-paper" android="md-paper" {...tabIconStyle}/>}>
                    	<Scene key="DiscoverScreen" component={Discover} hideNavBar />
                        <Scene key="Sports" title="Sports" component={Sports} navBarButtonColor={{ tintColor: 'White' }} {...eventsProps} back/>
                        <Scene key="Volunteers" title="Volunteers" component={Volunteers} navBarButtonColor={{ tintColor: 'White' }} {...eventsProps} back/>
                        <Scene key="Lectures" title="Lectures" component={Lectures} navBarButtonColor={{ tintColor: 'White' }} {...eventsProps} back/>
                        <Scene key="Workshops" title="Workshops" component={Workshops} navBarButtonColor={{ tintColor: 'White' }} {...eventsProps} back/>
                    </Stack>
                    <Stack key="Following" title="Following" icon={() => <Icon ios="ios-add-circle" android="md-add-circle" {...tabIconStyle}/>} {...stackProps} >
                    	<Scene key="FollowingScreen" component={Following} />
                    </Stack>
                    <Stack key="Profile" title="Profile" icon={() => <Icon ios="ios-person" android="md-person" {...tabIconStyle}/>} {...stackProps}>
                    	<Scene key="Profile" component={Profile} initial={true} type={ActionConst.REPLACE} />
                    </Stack>
                    </Tabs>
        
                    </Stack>
                </Scene>
            </Router>
        )
    }
}