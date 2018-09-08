import {query,deleteById} from '../services/sort'
export default {
  namespace: 'sorts',
  state: {
    data: ''
  },
  subscriptions: {
    setup({dispatch, history}) {
      history.listen(location => {
        if (location.pathname === '/sort') {
          dispatch({
            type: 'querySort',
            payload: {}
          });
        }
      });
    },
  },
  effects: {
    * querySort({payload}, {put, call}) {
      //下面两行不好使
      const result = yield call(query);
      if (result) {
        yield put({
          type: 'querySortSuccess',
          payload: {
            data: result.data
          }
        });
      }
    },
    * deleteSort({payload}, {put, call}) {
    console.log(payload)
    const result = yield call(deleteById);
    console.log(result)
    if (result) {
      yield put({
        type: 'querySortSuccess',
        payload: {
          data: result.data
        }
      });
    }
   }
  },
  reducers: {
    querySortSuccess(state,{payload:{data}}) {
      // console.log(data);
      const sortModel = {
        //下面需要状态添加状态
        list: data
      };
      return {...state, ...sortModel}
    }
  },
}
