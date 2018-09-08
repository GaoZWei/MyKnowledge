import { routerRedux } from 'dva/router';

export default {
  namespace: 'home',
  state: {
    activeIndex: 0,
  },
  effects: {
    // 路由跳转
    * redirect({ payload }, { put }) {
      yield put(routerRedux.push('/'));
    },
  },
  subscriptions: {
    setup({ dispatch, history }) {
      history.listen(location => {
        // 此处路由拦截跳转
        // if (location.pathname == '/') {
        //     dispatch({
        //         type: 'redirect'
        //     });
        //     dispatch({
        //         type: 'updateActiveIndex',
        //         payload: '/'
        //     });
        // } else {
        //     dispatch({
        //         type: 'updateActiveIndex',
        //         payload: location.pathname
        //     });
        // }
        dispatch({
          type: 'updateActiveIndex',
          payload: location.pathname
        });
      });
    },
  },
  reducers: {
    updateActiveIndex(state, action) {
      let pathname = action.payload;
      let activeIndex = 1;
      if (/^\/$/.test(pathname)) {
        activeIndex = 1;
      } else if (/example/.test(pathname)) {
        activeIndex = 2;
      } else if (/test2/.test(pathname)) {
        activeIndex = 3;
      } else if (/test3/.test(pathname)) {
        activeIndex = 4;
      } else {
        activeIndex = 0;
      }
      return { ...state, activeIndex: activeIndex };
    }
  },

}
