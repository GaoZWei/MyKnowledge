import {doLogin, doLogout} from '../services/login';
import {routerRedux} from 'dva/router';

export default {

  namespace: 'userLogin',

  state: {
    username: '',
    isLogin: false,
    modalVisible: false,
    authToken: '',
    pathname: '/',
    logupModalVisible: false
  },

  reducers: {
    login(state, action) {
      return {
        ...state,
        modalVisible: true
      };
    },
    loginSuccess(state, action) {
      let userInfo = action.payload;
      return {
        ...state,
        ...userInfo,
        isLogin: true,
        modalVisible: false
      };
    },
    logoutSuccess(state, action) {
      return {
        ...state,
        username: '',
        authToken: '',
        isLogin: false
      };
    },
    hideModal(state) {
      return {
        ...state,
        modalVisible: false
      };
    },
  },

  effects: {
    * doLogin({payload}, {call, put}) {
      let {userData, resolve, reject} = payload;
      console.log(userData)
      const {data} = yield call(doLogin, userData);
      console.log(data)
      //if (data && data.success) {
      if (data) {
        let userInfo = data.msg;
        console.log(userInfo)
        yield sessionStorage.setItem('userInfo', JSON.stringify(userInfo));
        //登录成功
        // yield put({
        //   type: 'loginSuccess',
        //   payload: userInfo
        // });
        if (data.msg == 'success') {
          // 跳转到sort页
          yield put(routerRedux.push('/sort'));
          resolve();
        }
        else {
          reject(data.msg)
        }
      } else {
        reject(data);
      }
    },
    // * doLogout({payload}, {call, put}) {
    //   const {data} = yield call(doLogout);
    //
    //   if (data && data.success) {
    //     yield sessionStorage.removeItem('userInfo')
    //     //退出登录成功
    //     yield put({
    //       type: 'logoutSuccess',
    //       payload: data.userInfo
    //     });
    //     yield put(routerRedux.push('/login'));
    //   }
    // },
  },
  subscriptions: {
    setup({dispatch, history}) {

    },
  },

}
